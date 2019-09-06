package com.xugter.cooridnatorlayoutstudy.realxiami;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.xugter.cooridnatorlayoutstudy.other.DisplayUtils;

public class ListBehavior extends CoordinatorLayout.Behavior<View> {

    private int searchBarHeight = 0;
    private int headerHeight = 0;
    private int bannerHeight = 0;
    private int bottomHeight = 0;

    private boolean startPos = true;
    private int scrollMode = 0;

    public ListBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
        searchBarHeight = DisplayUtils.dp2px(context, 45);
        headerHeight = DisplayUtils.dp2px(context, 48);
        bannerHeight = DisplayUtils.dp2px(context, 127);
        bottomHeight = DisplayUtils.dp2px(context, 43);
    }

    @Override
    public boolean onLayoutChild(@NonNull CoordinatorLayout parent, @NonNull View child, int layoutDirection) {
        child.layout(0, headerHeight, child.getMeasuredWidth(), parent.getMeasuredHeight() - bottomHeight);
        child.setY(searchBarHeight + headerHeight + bannerHeight);
        return true;
    }

    @Override
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View child, @NonNull View directTargetChild, @NonNull View target, int axes, int type) {
        return true;
    }

    @Override
    public boolean onTouchEvent(@NonNull CoordinatorLayout parent, @NonNull View child, @NonNull MotionEvent ev) {
        return super.onTouchEvent(parent, child, ev);
    }

    @Override
    public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout parent, @NonNull View child, @NonNull MotionEvent ev) {
        if (ev.getAction() == 0) {
            if (child.getScrollY() > 0) {
                startPos = false;
            } else {
                startPos = true;
            }
            scrollMode = 0;
        }
        return super.onInterceptTouchEvent(parent, child, ev);
    }

    @Override
    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View child, @NonNull View target, int dx, int dy, @NonNull int[] consumed, int type) {
        if (startPos) {
            if (scrollMode == 0) {
                if (child.getY() == headerHeight) {
                    if (dy > 0) {
                        scrollMode = 1;
                    } else {
                        scrollMode = -1;
                    }
                } else {
                    scrollMode = -1;
                }
            }
            if (scrollMode > 0) return;
            if (dy > 0) {
                if (child.getY() > headerHeight) {
                    float targetPos = child.getY() - dy;
                    if (targetPos > headerHeight) {
                        child.setY(targetPos);
                    } else {
                        child.setY(headerHeight);
                    }
                }
            } else {
                if (child.getY() < searchBarHeight + headerHeight + bannerHeight) {
                    float targetPos = child.getY() - dy;
                    if (targetPos < searchBarHeight + headerHeight + bannerHeight) {
                        child.setY(targetPos);
                    } else {
                        child.setY(searchBarHeight + headerHeight + bannerHeight);
                    }
                }
            }
            consumed[1] = dy;
        }
    }
}