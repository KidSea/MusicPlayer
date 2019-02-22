package com.leslie.musicplayer.ui.mainpage.fragment;

import android.view.View;
import android.widget.TextView;

import com.leslie.musicplayer.R;
import com.leslie.musicplayer.base.BaseFragment;

/**
 * Created by yuxuehai on 19-02-20.
 */
public class VideoFragment extends BaseFragment {
    @Override
    protected int requestLayoutId() {
        return R.layout.main_fragment;
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        TextView ivContent = view.findViewById(R.id.iv_content);
        ivContent.setText("Video");
    }
}
