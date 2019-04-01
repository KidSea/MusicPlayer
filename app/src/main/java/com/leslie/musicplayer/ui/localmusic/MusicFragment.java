package com.leslie.musicplayer.ui.localmusic;

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
import com.leslie.musicplayer.viewModel.localmusic.MusicViewModel;
import com.leslie.musicplayer.widget.CustomerScrollView;

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
        mBindingView.scrollLayout.setScrollChangedListener(new CustomerScrollView.OnScrollChangedListener() {
            @Override
            public void onScrollChanged(int x, int y, int oldxX, int oldY) {
                Log.d(TAG, "onScrollChanged");
                if (mBindingView.scrollLayout.isAtTop()) {
                    mBindingView.musicListRecyclerview.setInterceptParent(false);
                }else if (mBindingView.scrollLayout.isAtBottom()) {
                    mBindingView.musicListRecyclerview.setInterceptParent(false);
                } else {
                    mBindingView.musicListRecyclerview.setInterceptParent(true);
                }
            }
        });
        mBindingView.musicListRecyclerview.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                //currentCanScrollDown记录当前列表的可滚动状态，false表示列表已经滑到底部边界,边界下边已经没内容了
                boolean currentCanScrollDown = recyclerView.canScrollVertically(1);
                //currentCanScrollUp记录当前列表的可滚动状态，false表示列表已经滑到顶部边界,边界上边已经没内容了
                boolean currentCanScrollUp = recyclerView.canScrollVertically(-1);
                mBindingView.musicListRecyclerview.setInterceptParent(!(currentCanScrollDown || currentCanScrollUp));

            }
        });
    }

    @Override
    protected void initData() {
        super.initData();
        adapter = new MusicListAdapter();
        adapter.addDatas(data);
        adapter.setHeaderView(mHeaderBinding);
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
}
