package com.leslie.musicplayer.base;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.leslie.musicplayer.R;
import com.leslie.musicplayer.ui.mainpage.fragment.QuickControlsFragment;
import com.leslie.musicplayer.utils.CommonThreadPool;

public class BaseMusicActivity extends BaseActivity {

    private QuickControlsFragment mControlsFragment; //底部播放控制栏

    protected void initView() {
        showQuickControl(true);
    }

    /**
     * @param show 显示或关闭底部播放控制栏
     */
    private void showQuickControl(final boolean show) {
        CommonThreadPool.COMMON_THREAD_POOL.execute(new Runnable() {
            @Override
            public void run() {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                if (show) {
                    if (mControlsFragment == null) {
                        FragmentManager fragmentManager = getSupportFragmentManager();
                        Fragment fragment = fragmentManager.findFragmentById(R.id.bottom_container);
                        if (fragment instanceof QuickControlsFragment) {
                            mControlsFragment = (QuickControlsFragment) fragment;
                        } else {
                            mControlsFragment = new QuickControlsFragment();
                        }
                        ft.add(R.id.bottom_container, mControlsFragment).commitAllowingStateLoss();
                    } else {
                        ft.show(mControlsFragment).commitAllowingStateLoss();
                    }
                } else {
                    if (mControlsFragment != null)
                        ft.hide(mControlsFragment).commitAllowingStateLoss();
                }
            }
        });
    }
}
