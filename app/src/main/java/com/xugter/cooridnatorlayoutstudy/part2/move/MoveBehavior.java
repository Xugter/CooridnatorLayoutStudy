package com.xugter.cooridnatorlayoutstudy.part2.move;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

import com.xugter.cooridnatorlayoutstudy.other.TouchView;

public class MoveBehavior extends CoordinatorLayout.Behavior<View> {

    public MoveBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(@NonNull CoordinatorLayout parent, @NonNull View child, @NonNull View dependency) {
        return dependency instanceof TouchView;
    }

    @Override
    public boolean onDependentViewChanged(@NonNull CoordinatorLayout parent, @NonNull View child, @NonNull View dependency) {
        int dependBottom = dependency.getBottom();
        child.setY(dependBottom + 50);
        child.setX(dependency.getLeft());
        return true;
    }
}