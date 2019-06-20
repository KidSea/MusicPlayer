package com.leslie.musicplayer.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;

import com.leslie.musicplayer.R;

/**
 * Created by yuxuehai on 19-6-20.
 */
public class AutoChangeTextView extends TextView {

    private float mSelectedSize;
    private float mUnSelectedSize;

    public AutoChangeTextView(Context context) {
        this(context, null);
    }

    public AutoChangeTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AutoChangeTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.MySelectedSizes);
        if (ta != null) {
            mSelectedSize = ta.getDimension(R.styleable.MySelectedSizes_selectedSize, -1);
            mUnSelectedSize = ta.getDimension(R.styleable.MySelectedSizes_unSelectedSize, -1);
        }

        if (ta != null) {
            ta.recycle();
        }
    }

    @Override
    public void setSelected(boolean selected) {
        Animation animation;
        if (selected) {
            animation = new AlphaAnimation(0.4F, 1F);
            animation.setDuration(500);
            setAnimation(animation);
            setTextSize(TypedValue.COMPLEX_UNIT_PX, mSelectedSize);
        } else {
            setTextSize(TypedValue.COMPLEX_UNIT_PX, mUnSelectedSize);
        }
        super.setSelected(selected);
    }
}
