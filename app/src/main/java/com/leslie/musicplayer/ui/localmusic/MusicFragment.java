package com.leslie.musicplayer.ui.localmusic;

import android.animation.ObjectAnimator;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.leslie.musicplayer.MusicApplication;
import com.leslie.musicplayer.R;
import com.leslie.musicplayer.base.BaseModelFragment;
import com.leslie.musicplayer.common.MyLinearLayoutManager;
import com.leslie.musicplayer.databinding.MusicMainFragmentBinding;
import com.leslie.musicplayer.ui.localmusic.adapter.MusicListAdapter;
import com.leslie.musicplayer.utils.MusicTools;
import com.leslie.musicplayer.viewModel.localmusic.MusicViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuxuehai on 19-02-20.
 */
public class MusicFragment extends BaseModelFragment<MusicViewModel, MusicMainFragmentBinding> {
    private static final String TAG = MusicFragment.class.getSimpleName();

    private MusicListAdapter adapter;
    private View mHeaderBinding;
    private List<String> data = new ArrayList<>();

    @Override
    protected int requestLayoutId() {
        return R.layout.music_main_fragment;
    }

    @Override
    protected void initView() {
        super.initView();
        mHeaderBinding = LayoutInflater.from(getContext()).inflate(R.layout.local_number_header_layout,
                null, false);
        MyLinearLayoutManager layoutManager = new MyLinearLayoutManager(MusicApplication.getContext());
        layoutManager.setScrollEnabled(true);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mBindingView.musicListRecyclerview.setLayoutManager(layoutManager);
        mBindingView.musicListRecyclerview.setNestedScrollingEnabled(false);
        mBindingView.musicListRecyclerview.setHasFixedSize(false);
        mBindingView.musicListRecyclerview.setItemAnimator(new DefaultItemAnimator());
        mBindingView.musicListRecyclerview.addOnScrollListener(new MusicScrollListener());
        mBindingView.scrollLayout.setOnScrollChangeListener(new MusicScrollListener1());
    }

    @Override
    protected void initData() {
        super.initData();
        adapter = new MusicListAdapter();
        adapter.addDatas(data);
//        adapter.setHeaderView(mHeaderBinding);
        mBindingView.musicListRecyclerview.setAdapter(adapter);
    }

    @Override
    protected void loadData() {
        super.loadData();
        for (int i = 0; i < 50; i++) {
            String s = "music" + i;
            data.add(s);
        }
        for (int i = 0; i < 50; i++) {
            System.out.println(data.get(i));
        }
    }

    class MusicScrollListener extends RecyclerView.OnScrollListener {
        int numberHeight = MusicTools.dipToPx(175);
        int controlHeight = MusicTools.dipToPx(48);//随机播放区域高度
        int actionHeight = MusicTools.dipToPx(48);//ActionBar高度
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            Log.d(TAG, "onScrolled1");
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                Log.d(TAG, "onScrolled2");
                View child = layoutManager.findViewByPosition(0);
                if (child != null) {
                    Log.d(TAG, "onScrolled3");
                    int childTop = child.getTop();
                    Log.d(TAG, "childTop: " + childTop);
                    int childBottom = child.getBottom();
                    Log.d(TAG, "childBottom: " + childBottom);
                    if (childTop >= controlHeight) {
                        Log.d(TAG, "first: " + controlHeight);
                        moveHeaderViewTo(actionHeight);
                    } else if (childBottom <= controlHeight) {
                        Log.d(TAG, "second: " + controlHeight);
                        moveHeaderViewTo(controlHeight - numberHeight);
                    } else {
                        Log.d(TAG, "third: " + controlHeight);
                        moveHeaderViewTo(actionHeight + childTop - controlHeight);
                    }
                }
            } else {
                Log.d(TAG, "onScrolled4");
                Log.d(TAG, "forth: " + controlHeight);
                moveHeaderViewTo(controlHeight - numberHeight);
            }
        }
    }

    private void moveHeaderViewTo(int translation) {
        Log.d(TAG, "translation" + translation);
        ObjectAnimator animator = ObjectAnimator.ofFloat(mHeaderBinding, View.Y, (float) translation);
        animator.setDuration(0);
        animator.start();
    }

    class MusicScrollListener1 implements View.OnScrollChangeListener {
        int numberHeight = MusicTools.dipToPx(175);
        int controlHeight = MusicTools.dipToPx(48);//随机播放区域高度
        int actionHeight = MusicTools.dipToPx(48);//ActionBar高度

        @Override
        public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
            moveHeaderViewTo(scrollY);
            Log.d(TAG, "onScrolled: " + ", scrollX: " + scrollX + ", scrollY: " + scrollY + ", oldScrollX" + oldScrollX + ", oldScrollY: " + oldScrollY);
        }
    }

}
