package com.leslie.musicplayer.ui.localmusic;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;

import com.leslie.musicplayer.MusicApplication;
import com.leslie.musicplayer.R;
import com.leslie.musicplayer.base.BaseModelFragment;
import com.leslie.musicplayer.common.MyLinearLayoutManager;
import com.leslie.musicplayer.databinding.MusicMainFragmentBinding;
import com.leslie.musicplayer.viewModel.localmusic.MusicViewModel;

/**
 * Created by yuxuehai on 19-02-20.
 */
public class MusicFragment extends BaseModelFragment<MusicViewModel, MusicMainFragmentBinding> {
    private static final String TAG = MusicFragment.class.getSimpleName();

    @Override
    protected int requestLayoutId() {
        return R.layout.music_main_fragment;
    }

    @Override
    protected void initView() {
        MyLinearLayoutManager layoutManager = new MyLinearLayoutManager(MusicApplication.getContext());
        layoutManager.setScrollEnabled(true);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mBindingView.musicListRecyclerview.setLayoutManager(layoutManager);
        mBindingView.musicListRecyclerview.setNestedScrollingEnabled(false);
        mBindingView.musicListRecyclerview.setHasFixedSize(false);
        mBindingView.musicListRecyclerview.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    protected void initData() {
        mBindingView.setViewModel(mViewModel);
    }

    @Override
    protected void loadData() {
        mViewModel.requestData();
    }
}
