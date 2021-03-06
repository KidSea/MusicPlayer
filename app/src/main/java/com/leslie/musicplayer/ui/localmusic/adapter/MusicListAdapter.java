package com.leslie.musicplayer.ui.localmusic.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.leslie.musicplayer.R;
import com.leslie.musicplayer.base.BaseRecyclerAdapter;
import com.leslie.musicplayer.bean.Song;

/**
 * Created by yuxuehai on 19-3-27.
 */
public class MusicListAdapter extends BaseRecyclerAdapter<Song, MusicListAdapter.MusicListHolder> {

    @Override
    public MusicListHolder onCreate(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.music_list_item, parent, false);
        return new MusicListHolder(view);
    }

    @Override
    public void onBind(MusicListHolder viewHolder, int RealPosition, Song data) {
        (viewHolder).mTextView.setText(data.getName());
    }

    static class MusicListHolder extends BaseRecyclerAdapter.Holder {
        private TextView mTextView;

        public MusicListHolder(View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.tv_music_title);
        }
    }
}
