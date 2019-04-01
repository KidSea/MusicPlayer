package com.leslie.musicplayer.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

/**
 * Created by yuxuehai on 19-3-11.
 */
public class MusicRecyclerView extends RecyclerView {

    private boolean isInterceptParent = false;

    public MusicRecyclerView(Context context) {
        super(context);
    }

    public MusicRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MusicRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    /**
     *
     * @return
     */
    public boolean isAtTop(){
        return getScrollY() <= 0;
    }
    /**
     *
     * @return
     */
    public boolean isAtBottom(){
        return getScrollY() == getChildAt(getChildCount() - 1)
                .getBottom() + getPaddingBottom() - getHeight();
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        getParent().requestDisallowInterceptTouchEvent(isInterceptParent);
        return super.dispatchTouchEvent(ev);
    }

    public void setInterceptParent(boolean interceptParent) {
        Log.d("BaseModelFragment", "interceptParent: " + interceptParent);
        isInterceptParent = interceptParent;
    }
}
