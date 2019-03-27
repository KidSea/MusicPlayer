package com.leslie.musicplayer.common;

import android.os.AsyncTask;

import java.util.concurrent.Executors;

import io.reactivex.Scheduler;
import io.reactivex.internal.schedulers.RxThreadFactory;
import io.reactivex.schedulers.Schedulers;

public class ThreadPoolUtils {
    public static final Scheduler IO =
            Schedulers.from(Executors.newSingleThreadExecutor(new RxThreadFactory("IOThread-")));
    public static final Scheduler COMPUTATION = Schedulers.from(AsyncTask.THREAD_POOL_EXECUTOR);
}
