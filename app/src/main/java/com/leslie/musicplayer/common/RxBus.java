package com.leslie.musicplayer.common;

import android.util.Log;
import android.util.SparseArray;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

/**
 * Created by yuxuehai on 17-12-17.
 */

public class RxBus {
    private static final String TAG = "RxBus";
    private SparseArray<CompositeDisposable> mSubscriptionMap;
    private static volatile RxBus mRxBus;
    private final Subject<Object> mSubject;

    public static RxBus getInstance() {
        if (mRxBus == null){
            synchronized (RxBus.class){
                if(mRxBus == null){
                    mRxBus = new RxBus();
                }
            }
        }
        return mRxBus;
    }

    public RxBus(){
        mSubject = PublishSubject.create().toSerialized();
    }

    public void post(Object o){
        mSubject.onNext(o);
    }

    /**
     * 返回指定类型的带背压的Flowable实例
     */
    private <T> Flowable<T> getObservable(Class<T> type) {
        return mSubject
                .toFlowable(BackpressureStrategy.BUFFER)
                .ofType(type);
    }

    /**
     * 一个默认的订阅方法
     */
    private <T> Disposable doSubscribe(Class<T> type, Consumer<T> next, Consumer<Throwable> error) {
        return getObservable(type)
                .onBackpressureBuffer()
                .subscribeOn(ThreadPoolUtils.COMPUTATION)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(next, error);
    }

    /**
     * 是否已有观察者订阅
     */
    public boolean hasObservers() {
        return mSubject.hasObservers();
    }

    /**
     * 保存订阅后的disposable
     */
    public void addSubscription(Object o, Disposable disposable) {
        if (mSubscriptionMap == null) {
            mSubscriptionMap = new SparseArray<>();
        }
        int key = o.hashCode();
        if (mSubscriptionMap.get(key) != null) {
            mSubscriptionMap.get(key).add(disposable);
        } else {
            //一次性容器,可以持有多个并提供 添加和移除。
            CompositeDisposable disposables = new CompositeDisposable();
            disposables.add(disposable);
            mSubscriptionMap.put(key, disposables);
        }
    }

    /**
     * 取消订阅
     */
    private void unSubscribe(Object o) {
        if (mSubscriptionMap == null) {
            return;
        }

        int key = o.hashCode();
        if (mSubscriptionMap.get(key) != null) {
            mSubscriptionMap.get(key).dispose();
            mSubscriptionMap.remove(key);
        }
    }

    public <T> void registerRxBus(Object object, Class<T> eventType, Consumer<T> action) {
        Disposable disposable = doSubscribe(eventType, action, new Consumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {
                Log.e(TAG, " handle event: " + throwable.toString());
            }
        });
        addSubscription(object, disposable);
    }

    public void unRegisterRxBus(Object object) {
        unSubscribe(object);
    }
}