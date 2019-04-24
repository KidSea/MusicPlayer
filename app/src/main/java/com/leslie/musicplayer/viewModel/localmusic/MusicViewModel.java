package com.leslie.musicplayer.viewModel.localmusic;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;
import android.util.Log;

import com.leslie.musicplayer.bean.ShowControlBean;
import com.leslie.musicplayer.model.MusicModel;
import com.leslie.musicplayer.ui.localmusic.adapter.MusicListAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuxuehai on 19-3-27.
 */
public class MusicViewModel extends AndroidViewModel {
    private static final String TAG = MusicViewModel.class.getSimpleName();

    private MusicModel mMusicModel;
    private List<String> data = new ArrayList<>();
    public MusicListAdapter adapter = new MusicListAdapter();
    public ShowControlBean mControlBean = new ShowControlBean();

    public MusicViewModel(@NonNull Application application) {
        super(application);
        mMusicModel = new MusicModel();
    }

    public void requestData() {
        for (int i = 0; i < 50; i++) {
            String s = "music" + i;
            data.add(s);
        }
        adapter.addDatas(data);
        mControlBean.setShowControlView(!data.isEmpty());
    }
}
