package com.xugter.cooridnatorlayoutstudy.part3;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

import com.xugter.cooridnatorlayoutstudy.R;
import com.xugter.cooridnatorlayoutstudy.other.DisplayUtils;

public class BannerBehavior extends CoordinatorLayout.Behavior<View> {

    private int bannerHeight = 0;
    private int headerHeight = 0;

    public BannerBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
        bannerHeight = DisplayUtils.dp2px(context, 127);
        headerHeight = DisplayUtils.dp2px(context, 48);
    }

    @Override
    public boolean layoutDependsOn(@NonNull CoordinatorLayout parent, @NonNull View child, @NonNull View dependency) {
        return dependency.getId() == R.id.view_content;
    }

    @Override
    public boolean onDependentViewChanged(@NonNull CoordinatorLayout parent, @NonNull View child, @NonNull View dependency) {
        if (dependency.getY() >= headerHeight && dependency.getY() <= headerHeight + bannerHeight) {
            child.setAlpha((dependency.getY() - headerHeight) / bannerHeight);
            child.setY(headerHeight);
        } else if (dependency.getY() > headerHeight + bannerHeight) {
            child.setY(dependency.getY() - bannerHeight);
        }
        return true;
    }
}