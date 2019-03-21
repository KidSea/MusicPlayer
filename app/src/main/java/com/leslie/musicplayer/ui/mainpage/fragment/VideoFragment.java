package com.leslie.musicplayer.ui.mainpage.fragment;

import com.leslie.musicplayer.R;
import com.leslie.musicplayer.base.BaseModelFragment;
import com.leslie.musicplayer.databinding.MainFragmentBinding;
import com.leslie.musicplayer.viewModel.NoViewModel;

/**
 * Created by yuxuehai on 19-02-20.
 */
public class VideoFragment extends BaseModelFragment<NoViewModel, MainFragmentBinding> {
    @Override
    protected int requestLayoutId() {
        return R.layout.main_fragment;
    }

    @Override
    protected void initView() {
        mBindingView.ivContent.setText("Video");
    }
}
