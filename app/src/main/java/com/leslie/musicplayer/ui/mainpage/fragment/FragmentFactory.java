package com.leslie.musicplayer.ui.mainpage.fragment;

import android.util.SparseArray;

import com.leslie.musicplayer.base.BaseFragment;

/**
 * Created by yuxuehai on 19-02-20.
 */
public class FragmentFactory {
    private volatile static FragmentFactory sFragmentFactory;

    public static FragmentFactory getFragmentFactory() {

        if (sFragmentFactory == null) {
            synchronized (FragmentFactory.class) {
                if (sFragmentFactory == null) {
                    sFragmentFactory = new FragmentFactory();
                }
            }
        }
        return sFragmentFactory;
    }

    private SparseArray<BaseFragment> mFragmentMap = new SparseArray<BaseFragment>();


    public BaseFragment getFragment(int position) {
        BaseFragment fragment = mFragmentMap.get(position);


        //先从集合中取，如果没有才创建对象，可以提高性能
        if (fragment == null) {

            switch (position) {
                case 0:
                    fragment = new MusicFragment();
                    break;
                case 1:
                    fragment = new VideoFragment();
                    break;
                case 2:
                    fragment = new MovieListFragment();
                    break;
                default:
                    break;
            }

            mFragmentMap.put(position, fragment);
        }


        return fragment;
    }

    public void clearView() {
        if (mFragmentMap != null) {
            mFragmentMap.clear();
            mFragmentMap = null;
        }
    }
}
