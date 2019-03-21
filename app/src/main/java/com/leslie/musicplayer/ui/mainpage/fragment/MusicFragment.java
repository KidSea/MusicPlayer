package com.leslie.musicplayer.ui.mainpage.fragment;

import android.support.v7.widget.RecyclerView;

import com.leslie.musicplayer.R;
import com.leslie.musicplayer.base.BaseModelFragment;
import com.leslie.musicplayer.databinding.MusicMainFragmentBinding;
import com.leslie.musicplayer.viewModel.NoViewModel;

/**
 * Created by yuxuehai on 19-02-20.
 */
public class MusicFragment extends BaseModelFragment<NoViewModel, MusicMainFragmentBinding> {

    private RecyclerView mMuiscListRecyclerView;

    @Override
    protected int requestLayoutId() {
        return R.layout.music_main_fragment;
    }

    @Override
    protected void initView() {
        super.initView();
    }

    @Override
    protected void initData() {
        super.initData();
    }

    @Override
    protected void loadData() {
        super.loadData();
    }
}
