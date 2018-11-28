package com.xugter.cooridnatorlayoutstudy.xiami;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

import com.xugter.cooridnatorlayoutstudy.other.DisplayUtils;

public class HeaderBehavior extends CoordinatorLayout.Behavior<View> {
    float lastPos = 0;
    private int titleHeight = 0;

    public HeaderBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View child, @NonNull View directTargetChild, @NonNull View target, int axes, int type) {
        return true;
    }

    @Override
    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View child, @NonNull View target, int dx, int dy, @NonNull int[] consumed, int type) {
        lastPos = child.getTranslationY();
        if (titleHeight == 0) {
            titleHeight = DisplayUtils.dp2px(child.getContext(), 60);
        }
        if ((dy > 0 && lastPos > -titleHeight) || (dy < 0 && lastPos < 0)) {
            float y = lastPos - dy * titleHeight / (child.getHeight() - titleHeight);
            if (y < -titleHeight) {
                y = -titleHeight;
            } else if (y > 0) {
                y = 0;
            }
            child.setTranslationY(y);
            consumed[1] = dy;
        }
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed, type);
    }
}