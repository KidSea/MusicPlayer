package com.leslie.musicplayer.bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.leslie.musicplayer.BR;

/**
 * Created by yuxuehai on 19-4-8.
 */
public class ShowControlBean extends BaseObservable {
    private boolean showControlView = false;

    @Bindable
    public boolean isShowControlView() {
        return showControlView;
    }

    public void setShowControlView(boolean showControlView) {
        this.showControlView = showControlView;
        notifyPropertyChanged(BR.showControlView);
    }
}
