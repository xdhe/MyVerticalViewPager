package com.verticalviewpager.xiaodong.verticalviewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;

/**
 * Created by xiaodong on 17/4/12.
 * 优先获得事件
 */
public class ButtonImageView extends ImageView {
    public ButtonImageView(Context context) {
        super(context);
    }

    public ButtonImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ButtonImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(ev);
    }
}
