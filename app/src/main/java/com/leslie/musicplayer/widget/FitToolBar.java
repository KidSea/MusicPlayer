package com.leslie.musicplayer.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.WindowInsets;

public class FitToolBar extends Toolbar {
    public FitToolBar(Context context) {
        super(context);
    }

    public FitToolBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public FitToolBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public WindowInsets onApplyWindowInsets(WindowInsets insets) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof MarginLayoutParams) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = insets.getSystemWindowInsetTop();
        }
        return super.onApplyWindowInsets(insets);
    }
}
