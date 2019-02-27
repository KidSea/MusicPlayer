package com.leslie.musicplayer.ui.mainpage.fragment;

import com.leslie.musicplayer.R;
import com.leslie.musicplayer.base.BaseFragment;

/**
 * Created by yuxuehai on 19-2-26.
 */
public class QuickControlsFragment extends BaseFragment {
    private static QuickControlsFragment fragment;

    public static QuickControlsFragment newInstance() {
        return new QuickControlsFragment();
    }

    @Override
    protected int requestLayoutId() {
        return R.layout.main_fragment;
    }


}
