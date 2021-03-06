package com.leslie.musicplayer.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    private static final String TAG = BaseActivity.class.getName();

    protected Context getcontext() {
        return getApplicationContext();
    }

    protected Activity getActivityContext() {
        return this;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

}
