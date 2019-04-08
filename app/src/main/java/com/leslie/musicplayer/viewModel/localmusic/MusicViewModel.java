package com.leslie.musicplayer.viewModel.localmusic;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.leslie.musicplayer.bean.ShowControlBean;

/**
 * Created by yuxuehai on 19-3-27.
 */
public class MusicViewModel extends AndroidViewModel {

    public ShowControlBean mControlBean = new ShowControlBean();

    public MusicViewModel(@NonNull Application application) {
        super(application);
    }




}
