package com.leslie.musicplayer.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by yuxuehai on 19-3-5.
 */
public class CommonThreadPool {
    public static final ExecutorService COMMON_THREAD_POOL = Executors.newCachedThreadPool();
}
