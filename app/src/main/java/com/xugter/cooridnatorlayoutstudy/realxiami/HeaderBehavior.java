package com.xugter.cooridnatorlayoutstudy.realxiami;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

import com.xugter.cooridnatorlayoutstudy.other.DisplayUtils;

public class HeaderBehavior extends CoordinatorLayout.Behavior<View> {

    private int top = 0;
    private Context context;

    public HeaderBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    @Override
    public boolean onLayoutChild(@NonNull CoordinatorLayout parent, @NonNull View child, int layoutDirection) {
        child.layout(0, getTop(), child.getMeasuredWidth(), child.getMeasuredHeight() + getTop());
        return true;
    }

    @Override
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View child, @NonNull View directTargetChild, @NonNull View target, int axes, int type) {
        return true;
    }

    @Override
    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View child, @NonNull View target, int dx, int dy, @NonNull int[] consumed, int type) {
        if (dy > 0) {
            if (child.getY() > 0) {
                float targetPos = child.getY() - dy;
                if (targetPos > 0) {
                    child.setY(targetPos);
                    consumed[1] = dy;
                } else {
                    consumed[1] = (int) child.getY();
                    child.setY(0);
                }
            }
        } else {
            if (child.getY() < getTop()) {
                float targetPos = child.getY() - dy;
                if (targetPos < getTop()) {
                    child.setY(targetPos);
                    consumed[1] = dy;
                } else {
                    consumed[1] = (int) child.getY() - getTop();
                    child.setY(getTop());
                }
            }
        }
    }

    private int getTop() {
        if (top == 0) {
            top = DisplayUtils.dp2px(context, 45f);
        }
        return top;
    }
}