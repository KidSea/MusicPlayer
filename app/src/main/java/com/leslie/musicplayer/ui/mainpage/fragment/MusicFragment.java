package com.leslie.musicplayer.ui.mainpage.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.leslie.musicplayer.R;
import com.leslie.musicplayer.base.BaseFragment;
import com.leslie.musicplayer.utils.ViewUtils;

/**
 * Created by yuxuehai on 19-02-20.
 */
public class MusicFragment extends BaseFragment {

    private RecyclerView mMuiscListRecyclerView;

    @Override
    protected int requestLayoutId() {
        return R.layout.music_main_fragment;
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        mMuiscListRecyclerView = ViewUtils.findView(view, R.id.music_list_recyclerview);
    }

    @Override
    protected void loadData() {
        super.loadData();
    }
}
