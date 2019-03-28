package com.leslie.musicplayer.ui.localmusic;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;

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

    private MusicListAdapter adapter;
    private View mHeaderBinding;
    private List<String> data = new ArrayList<>();

    @Override
    protected int requestLayoutId() {
        return R.layout.music_main_fragment;
    }

    @Override
    protected void initView() {
        super.initView();
        mHeaderBinding = LayoutInflater.from(getContext()).inflate(R.layout.local_number_header_layout,
                null, false);
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
        adapter.setHeaderView(mHeaderBinding);
        mBindingView.musicListRecyclerview.setAdapter(adapter);
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
    }
}
