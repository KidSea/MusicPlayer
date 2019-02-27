package com.leslie.musicplayer.base;

import android.support.v4.app.FragmentTransaction;

import com.leslie.musicplayer.R;
import com.leslie.musicplayer.ui.mainpage.fragment.QuickControlsFragment;

public class BaseMusicActivity extends BaseActivity {

    private QuickControlsFragment fragment; //底部播放控制栏

    @Override
    protected void initView() {
        showQuickControl(true);
        super.initView();
    }

    /**
     * @param show 显示或关闭底部播放控制栏
     */
    private void showQuickControl(boolean show) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (show) {
            if (fragment == null) {
                fragment = QuickControlsFragment.newInstance();
                ft.add(R.id.bottom_container, fragment).commitAllowingStateLoss();
            } else {
                ft.show(fragment).commitAllowingStateLoss();
            }
        } else {
            if (fragment != null)
                ft.hide(fragment).commitAllowingStateLoss();
        }
    }
}
