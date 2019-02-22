package com.leslie.musicplayer.ui.mainpage.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.leslie.musicplayer.ui.mainpage.fragment.FragmentFactory;
import com.leslie.musicplayer.utils.Constants;


/**
 * Created by yuxuehai on 19-2-22.
 */
public class MainPagerAdapter extends FragmentStatePagerAdapter {
    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return FragmentFactory.getFragmentFactory().getFragment(position);
    }

    @Override
    public int getCount() {
        return Constants.DEFAULT_CHANNELS.length;
    }

    public void destoryAadapter() {
        FragmentFactory.getFragmentFactory().clearView();
    }
}
