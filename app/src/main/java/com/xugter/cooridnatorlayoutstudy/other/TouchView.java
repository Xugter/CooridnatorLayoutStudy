package com.xugter.cooridnatorlayoutstudy.other;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

public class TouchView extends View {

    private float mLastX;
    private float mLastY;

    public TouchView(Context context) {
        this(context, null);
    }

    public TouchView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TouchView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                mLastX = event.getX();
                mLastY = event.getY();
                break;

            case MotionEvent.ACTION_MOVE:
                int deltax = (int) (event.getX() - mLastX);
                int deltay = (int) (event.getY() - mLastY);
                if (Math.abs(deltax) > ViewConfiguration.getTouchSlop() || Math.abs(deltay) > ViewConfiguration.getTouchSlop()) {
                    ViewCompat.offsetTopAndBottom(this, deltay);
                    ViewCompat.offsetLeftAndRight(this, deltax);
                }
                break;

            case MotionEvent.ACTION_UP:
                mLastX = event.getX();
                mLastY = event.getY();
                break;

            default:
                break;
        }
        return true;
    }
}
