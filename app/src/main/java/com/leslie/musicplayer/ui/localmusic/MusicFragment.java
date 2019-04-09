package com.leslie.musicplayer.ui.localmusic;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.leslie.musicplayer.MusicApplication;
import com.leslie.musicplayer.R;
import com.leslie.musicplayer.base.BaseModelFragment;
import com.leslie.musicplayer.common.MyLinearLayoutManager;
import com.leslie.musicplayer.databinding.MusicMainFragmentBinding;
import com.leslie.musicplayer.ui.localmusic.adapter.MusicListAdapter;
import com.leslie.musicplayer.viewModel.localmusic.MusicViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuxuehai on 19-02-20.
 */
public class MusicFragment extends BaseModelFragment<MusicViewModel, MusicMainFragmentBinding> {
    private static final String TAG = MusicFragment.class.getSimpleName();

    private MusicListAdapter adapter;
    private List<String> data = new ArrayList<>();

    @Override
    protected int requestLayoutId() {
        return R.layout.music_main_fragment;
    }

    @Override
    protected void initView() {
        super.initView();
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
        super.initData();
        adapter = new MusicListAdapter();
        adapter.addDatas(data);
        mBindingView.musicListRecyclerview.setAdapter(adapter);
        mBindingView.setViewModel(mViewModel);
    }

    @Override
    protected void loadData() {
        super.loadData();
        for (int i = 0; i < 50; i++) {
            String s = "music" + i;
            data.add(s);
        }
        for (int i = 0; i < 50; i++) {
            System.out.println(data.get(i));
        }
        Log.d(TAG, "!data.isEmpty()" + !data.isEmpty());
        mViewModel.mControlBean.setShowControlView(!data.isEmpty());
    }
}
