package com.xugter.cooridnatorlayoutstudy.realxiami;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

import com.xugter.cooridnatorlayoutstudy.other.DisplayUtils;

public class ListBehavior extends CoordinatorLayout.Behavior<View> {

    private int searchBarHeight = 0;
    private int headerHeight = 0;
    private int bannerHeight = 0;
    private int bottomHeight = 0;

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
        return child.getY() >= headerHeight && child.getY() <= searchBarHeight + headerHeight + bannerHeight;
    }

    @Override
    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View child, @NonNull View target, int dx, int dy, @NonNull int[] consumed, int type) {
        if (dy > 0) {
            if (child.getY() > headerHeight) {
                float targetPos = child.getY() - dy;
                if (targetPos > headerHeight) {
                    child.setY(targetPos);
                    consumed[1] = dy;
                } else {
                    consumed[1] = (int) child.getY() - headerHeight;
                    child.setY(headerHeight);
                }
            }
        } else {
            if (child.getY() < searchBarHeight + headerHeight + bannerHeight) {
                float targetPos = child.getY() - dy;
                if (targetPos < searchBarHeight + headerHeight + bannerHeight) {
                    child.setY(targetPos);
                    consumed[1] = dy;
                } else {
                    consumed[1] = (int) child.getY() - searchBarHeight + headerHeight + bannerHeight;
                    child.setY(searchBarHeight + headerHeight + bannerHeight);
                }
            }
        }
    }
}