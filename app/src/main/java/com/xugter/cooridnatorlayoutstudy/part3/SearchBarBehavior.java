package com.xugter.cooridnatorlayoutstudy.part3;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

import com.xugter.cooridnatorlayoutstudy.R;
import com.xugter.cooridnatorlayoutstudy.other.DisplayUtils;

public class SearchBarBehavior extends CoordinatorLayout.Behavior<View> {

    private int searchBarHeight = 0;
    private Context context;

    public SearchBarBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    @Override
    public boolean layoutDependsOn(@NonNull CoordinatorLayout parent, @NonNull View child, @NonNull View dependency) {
        return dependency.getId() == R.id.img_header;
    }

    @Override
    public boolean onDependentViewChanged(@NonNull CoordinatorLayout parent, @NonNull View child, @NonNull View dependency) {
        float progress = dependency.getY() / getSearchBarHeight();
        child.setAlpha(progress * progress);
        return true;
    }

    private int getSearchBarHeight() {
        if (searchBarHeight == 0) {
            searchBarHeight = DisplayUtils.dp2px(context, 45);
        }
        return searchBarHeight;
    }
}