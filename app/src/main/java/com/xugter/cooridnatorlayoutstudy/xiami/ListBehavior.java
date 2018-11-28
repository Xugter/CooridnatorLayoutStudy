package com.xugter.cooridnatorlayoutstudy.xiami;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

import com.xugter.cooridnatorlayoutstudy.R;
import com.xugter.cooridnatorlayoutstudy.other.DisplayUtils;

public class ListBehavior extends CoordinatorLayout.Behavior<View> {

    private int titleHeight = 0;

    public ListBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(@NonNull CoordinatorLayout parent, @NonNull View child, @NonNull View dependency) {
        return dependency.getId() == R.id.view_header;
    }

    @Override
    public boolean onDependentViewChanged(@NonNull CoordinatorLayout parent, @NonNull View child, @NonNull View dependency) {
        if (titleHeight == 0) {
            titleHeight = DisplayUtils.dp2px(child.getContext(), 60);
        }
        child.setTranslationY(dependency.getHeight() + dependency.getTranslationY() * (dependency.getHeight() - titleHeight) / titleHeight);
        return true;
    }
}
