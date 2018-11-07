package com.leslie.musicplayer.ui.mainpage;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.transition.Fade;
import android.widget.RelativeLayout;

import com.leslie.musicplayer.R;

import static com.leslie.musicplayer.utils.PermissionUtils.REQUEST_CODE;
import static com.leslie.musicplayer.utils.PermissionUtils.hasAllPermissionsGranted;
import static com.leslie.musicplayer.utils.PermissionUtils.lacksPermissions;
import static com.leslie.musicplayer.utils.PermissionUtils.permissions;

public class SplashActivity extends AppCompatActivity {

    private RelativeLayout mSplashLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fade fade = new Fade();
        fade.setDuration(500);
        getWindow().setEnterTransition(fade);
        getWindow().setExitTransition(fade);

        setContentView(R.layout.splash_main);

        initView();
    }

    @Override
    public void onEnterAnimationComplete() {
        mSplashLayout.animate()
                .alpha(1)
                .setDuration(800)
                .start();
        super.onEnterAnimationComplete();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CODE && hasAllPermissionsGranted(grantResults)) {
            goToMain();
        } else {
            delayFinish();
        }
    }

    protected void initView() {
        mSplashLayout = findViewById(R.id.splash_layout);

        //动态申请权限，Android6.0以上使用
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && lacksPermissions(permissions)) {
            requestPermissions(permissions, REQUEST_CODE);
        } else {
            goToMain();
        }
    }

    private void delayFinish() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SplashActivity.this.finish();
            }
        }, 1000);
    }

    private void goToMain() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SplashActivity.this.startActivity(new Intent(SplashActivity.this, MusicPlayMainActivity.class));
                SplashActivity.this.delayFinish();
                SplashActivity.this.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        }, 1500);
    }
}
