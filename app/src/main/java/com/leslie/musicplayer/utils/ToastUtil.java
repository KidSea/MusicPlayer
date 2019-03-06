package com.leslie.musicplayer.utils;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.widget.Toast;

import com.leslie.musicplayer.MusicApplication;

import me.drakeet.support.toast.ToastCompat;

/**
 * @author yuxuehai
 */
public class ToastUtil {
    private static ToastCompat mToast;

    @SuppressLint("ShowToast")
    public static void showToast(String text) {
        if (!TextUtils.isEmpty(text)) {
            if (mToast == null) {
                mToast = ToastCompat.makeText(MusicApplication.getContext(), text, Toast.LENGTH_SHORT);
            } else {
                mToast.cancel();
                mToast = ToastCompat.makeText(MusicApplication.getContext(), text, Toast.LENGTH_SHORT);
            }
            mToast.setDuration(Toast.LENGTH_SHORT);
            mToast.setText(text);
            mToast.show();
        }
    }

    @SuppressLint("ShowToast")
    public static void showToastLong(String text) {
        if (!TextUtils.isEmpty(text)) {
            if (mToast == null) {
                mToast = ToastCompat.makeText(MusicApplication.getContext(), text, Toast.LENGTH_LONG);
            } else {
                mToast.cancel();
                mToast = ToastCompat.makeText(MusicApplication.getContext(), text, Toast.LENGTH_LONG);
            }
            mToast.setDuration(Toast.LENGTH_LONG);
            mToast.setText(text);
            mToast.show();
        }
    }

}
