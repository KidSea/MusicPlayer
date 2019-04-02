package com.leslie.musicplayer.utils;

import com.leslie.musicplayer.MusicApplication;

/**
 * Created by yuxuehai on 19-4-2.
 */
public class MusicTools {

    public static int dipToPx(int dip) {
        return (int) (dip * getSystemDensity() + 0.5f);
    }

    public static int dipToPx(float dip) {
        return (int) (dip * getSystemDensity() + 0.5f);
    }

    /**
     * 系统默认Density 设置显示大小会发生改变
     * @return
     */
    public static float getSystemDensity() {
        return MusicApplication.getContext().getResources().getDisplayMetrics().density;
    }
}
