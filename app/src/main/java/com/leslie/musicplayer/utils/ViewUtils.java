package com.leslie.musicplayer.utils;

import android.graphics.Color;
import android.graphics.Rect;
import android.support.annotation.ColorInt;
import android.support.annotation.IdRes;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/*
 * Created by yuxuehai on 19-03-06.
 */
public class ViewUtils {

    public static void setMarqueeEnabled(TextView textView, boolean enabled) {
        if (textView == null) {
            return;
        }
        textView.setSingleLine();
        textView.setMarqueeRepeatLimit(-1);
        textView.setFocusable(true);
        textView.setFocusableInTouchMode(true);
        if (enabled) {
            textView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
            textView.requestFocus();
        } else {
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.clearFocus();
        }

    }

    /**
     * 获取指定类型的父view
     * @param view
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T extends View> List<T> findParentViews(View view, Class<T> clazz) {
        List<T> result = new ArrayList<>();
        View parent = (View) view.getParent();
        while (parent != null) {
            if (clazz.isInstance(parent)) {
                result.add((T) parent);
            }
            parent = (View) parent.getParent();
        }
        return result;
    }

    /**
     * 获取指定类型的父view
     * @param view
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T extends View> T findParentView(View view, Class<T> clazz) {
        View parent = (View) view.getParent();
        while (parent != null) {
            if (clazz.isInstance(parent)) {
                return (T) parent;
            }
            parent = (View) parent.getParent();
        }
        return null;
    }

    /**
     * 查找view简易操作
     * @param root
     * @param rsid
     * @param <T>
     * @return
     */
    public static <T extends View> T findView(View root, @IdRes int rsid) {
        return (T) root.findViewById(rsid);
    }

    /**
     * 设置view使能状态
     * @param view
     * @param enabled
     */
    public static void setEnabled(View view, boolean enabled) {
        if (view != null) {
            view.setEnabled(enabled);
            view.setAlpha(enabled ? 1f : 0.5f);
        }
    }

    /**
     * 扩大点击区域
     * @param view
     */
    public static void expandClick(final View view) {
        if (view == null) {
            return;
        }
        view.post(new Runnable() {
            @Override
            public void run() {
                if (view.getParent() instanceof View) {
                    Rect rect = new Rect();
                    view.getHitRect(rect);
                    rect.left -= 60;
                    rect.top -= 60;
                    rect.right += 60;
                    rect.bottom += 60;
                    ((View) view.getParent()).setTouchDelegate(new TouchDelegate(rect, view));
                }
            }
        });
    }

    /**
     * 扩大点击区域
     * @param seekbar
     * @param seekbarParent
     */
    public static void expandSeekbarClick(final View seekbar,final View seekbarParent) {
        if (seekbar == null || seekbarParent == null) {
            return;
        }
        seekbar.post(new Runnable() {
            @Override
            public void run() {
                seekbarParent.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent event) {
                        Rect seekRect = new Rect();
                        seekbar.getHitRect(seekRect);

                        if ((event.getY() >= (seekRect.top - 20)) && (event.getY() <= (seekRect.bottom + 20))) {
                            float y = seekRect.top + seekRect.height() / 2;
                            //seekBar only accept relative x
                            float x = event.getX() - seekRect.left;
                            if (x < 0) {
                                x = 0;
                            } else if (x > seekRect.width()) {
                                x = seekRect.width();
                            }
                            MotionEvent me = MotionEvent.obtain(event.getDownTime(), event.getEventTime(),
                                    event.getAction(), x, y, event.getMetaState());
                            return seekbar.onTouchEvent(me);
                        }
                        return false;
                    }
                });
            }
        });
    }

    public static @ColorInt int getCombinedColor(TextView textView) {
        if (textView == null) {
            return 0;
        } else {
            int color = textView.getCurrentTextColor();
            int alpha = (int) (Color.alpha(color) * textView.getAlpha());
            int red = Color.red(color);
            int green = Color.green(color);
            int blue = Color.blue(color);
            return Color.argb(alpha, red, green, blue);
        }
    }

    /**
     * 剔除view
     * @param view
     */
    public static void removeView(View view) {
        if (view != null && view.getParent() instanceof ViewGroup) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }
}
