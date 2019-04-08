package com.leslie.musicplayer.base;

import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
        mBindingView = DataBindingUtil.inflate(inflater, requestLayoutId(), container, false);
        initView();
        return mBindingView.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initViewModel();
        initData();
        loadData();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mContext = null;
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


    /**
     * 布局
     *
     * @return
     */
    protected abstract int requestLayoutId();
}
