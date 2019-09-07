package com.xugter.cooridnatorlayoutstudy.part2.layout;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

public class LayoutBehavior extends CoordinatorLayout.Behavior<View> {

    public LayoutBehavior() {
    }

    public LayoutBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onLayoutChild(@NonNull CoordinatorLayout parent, @NonNull View child, int layoutDirection) {
        child.layout(0, 500, child.getMeasuredWidth(), 500 + child.getMeasuredHeight());
        return true;
    }
}