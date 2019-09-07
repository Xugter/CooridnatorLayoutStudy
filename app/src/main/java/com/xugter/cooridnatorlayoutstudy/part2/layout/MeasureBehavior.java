package com.xugter.cooridnatorlayoutstudy.part2.layout;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class MeasureBehavior extends CoordinatorLayout.Behavior<View> {

    public MeasureBehavior() {
    }

    public MeasureBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onMeasureChild(@NonNull CoordinatorLayout parent, @NonNull View child, int parentWidthMeasureSpec, int widthUsed, int parentHeightMeasureSpec, int heightUsed) {
        int newHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(300, View.MeasureSpec.EXACTLY);
        int newWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(500, View.MeasureSpec.EXACTLY);
        parent.onMeasureChild(child, newWidthMeasureSpec, widthUsed, newHeightMeasureSpec, heightUsed);
        return true;
    }

    @Override
    public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout parent, @NonNull View child, @NonNull MotionEvent ev) {
        Log.i("MeasureBehavior", "onInterceptTouchEvent======action=" + ev.getAction());
        return super.onInterceptTouchEvent(parent, child, ev);
    }

    @Override
    public boolean onTouchEvent(@NonNull CoordinatorLayout parent, @NonNull View child, @NonNull MotionEvent ev) {
        Log.i("MeasureBehavior", "onTouchEvent======action=" + ev.getAction());
        return super.onTouchEvent(parent, child, ev);
    }
}