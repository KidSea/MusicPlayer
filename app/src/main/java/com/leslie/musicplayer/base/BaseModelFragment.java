package com.leslie.musicplayer.base;

import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
<<<<<<< HEAD
=======
import android.databinding.DataBindingUtil;
>>>>>>> develop local music day3
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
<<<<<<< HEAD
=======

>>>>>>> develop local music day3
import com.leslie.musicplayer.utils.ClassUtils;

/**
 * Created by yuxuehai on 19-3-21.
 */
public abstract class BaseModelFragment<VM extends AndroidViewModel,
        SV extends ViewDataBinding> extends Fragment {

    // ViewModel
    protected VM mViewModel;
    // 布局view
    protected SV mBindingView;
    // fragment是否显示了
    protected boolean mIsVisible = false;
    private Context mContext;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
<<<<<<< HEAD
        return super.onCreateView(inflater, container, savedInstanceState);
=======
        mBindingView = DataBindingUtil.inflate(inflater, requestLayoutId(), container, false);
        initView();
        return mBindingView.getRoot();
    }

    /**
     * 在这里实现Fragment数据的缓加载.
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            mIsVisible = true;
            onVisible();
        } else {
            mIsVisible = false;
            onInvisible();
        }
>>>>>>> develop local music day3
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
<<<<<<< HEAD
=======
        initViewModel();
        initData();
>>>>>>> develop local music day3
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mContext = null;
    }

<<<<<<< HEAD
=======
    protected void onVisible() {
        loadData();
    }

    protected void onInvisible() {
    }

    /**
     * View需要初始化的
     */
    protected void initView() {
    }

    /**
     * 初始化数据
     */
    protected void initData() {
    }

>>>>>>> develop local music day3
    /**
     * 显示时加载数据,需要这样的使用
     * 注意声明 isPrepared，先初始化
     * 生命周期会先执行 setUserVisibleHint 再执行onActivityCreated
     * 在 onActivityCreated 之后第一次显示加载数据，只加载一次
     */
    protected void loadData() {
    }

    /**
     * 初始化ViewModel
     */
    private void initViewModel() {
        Class<VM> viewModelClass = ClassUtils.getViewModel(this);
        if (viewModelClass != null) {
            this.mViewModel = ViewModelProviders.of(this).get(viewModelClass);
        }
    }

<<<<<<< HEAD

=======
    /**
     * 布局
     *
     * @return
     */
    protected abstract int requestLayoutId();
>>>>>>> develop local music day3
}
