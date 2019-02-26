package com.leslie.musicplayer;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by yuxuehai on 18-7-24.
 */

public class MusicApplication extends Application {

    private static final String TAG = "MusicApplication";

    private static Context sContext;
    private static Application sApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        sContext = this;
        sApplication = this;
    }

    public static Application getApplication() {
        return sApplication;
    }

    public static Context getContext() {
        return sContext;
    }

    private void init() {
        // do somethings
        if (LeakCanary.isInAnalyzerProcess(this)) {//1
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
    }
}
