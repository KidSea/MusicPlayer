package com.leslie.musicplayer.ui.mainpage.fragment;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.leslie.musicplayer.R;
import com.leslie.musicplayer.base.BaseFragment;
import com.leslie.musicplayer.utils.ToastUtil;
import com.leslie.musicplayer.utils.ViewUtils;

/**
 * Created by yuxuehai on 19-2-26.
 */
public class QuickControlsFragment extends BaseFragment implements View.OnClickListener {
    private FrameLayout mMiniContainer;
    private ImageView mAlbumCover;
    private ImageView mMusicNext;
    private ImageView mMusicPlay;
    private ImageView mAddFavorite;
    private TextView mMusicSlogan;
    private TextView mTitle;
    private TextView mArtist;

    @Override
    protected void initView(View view) {
        super.initView(view);
        mMiniContainer = ViewUtils.findView(view, R.id.fl_mini_container);
        mAlbumCover = ViewUtils.findView(view, R.id.iv_album_cover);
        mMusicNext = ViewUtils.findView(view, R.id.iv_next);
        mMusicPlay = ViewUtils.findView(view, R.id.iv_play);
        mAddFavorite = ViewUtils.findView(view, R.id.iv_add_to_favorite);
        mMusicSlogan = ViewUtils.findView(view, R.id.tv_music_slogan);
        mTitle = ViewUtils.findView(view, R.id.tv_title_text);
        mArtist = ViewUtils.findView(view, R.id.tv_artist_text);

        mMiniContainer.setOnClickListener(this);
        mAlbumCover.setOnClickListener(this);
        mMusicNext.setOnClickListener(this);
        mMusicPlay.setOnClickListener(this);
        mAddFavorite.setOnClickListener(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected int requestLayoutId() {
        return R.layout.mini_music_fragment;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        ToastUtil.showToast("show id: " + id);
        switch (id) {
            case R.id.iv_album_cover:
                break;
            case R.id.iv_next:
                break;
            case R.id.iv_play:
                break;
            case R.id.iv_add_to_favorite:
                break;
        }
    }
}
