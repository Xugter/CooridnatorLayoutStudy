package com.xugter.cooridnatorlayoutstudy.part3;

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
        //来定位list的初始位置，并进行第一次的位移
        child.layout(0, headerHeight, child.getMeasuredWidth(), parent.getMeasuredHeight() - bottomHeight);
        child.setY(searchBarHeight + headerHeight + bannerHeight);
        return true;
    }

    @Override
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View child, @NonNull View directTargetChild, @NonNull View target, int axes, int type) {
        return true;
    }

    @Override
    public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout parent, @NonNull View child, @NonNull MotionEvent ev) {
        if (ev.getAction() == 0) {
            if (child.getScrollY() > 0) {
                //List没有滚到顶部，先进行自己滚动，不触发嵌套滑动
                startPos = false;
            } else {
                //List滚动到顶部，待确定触发嵌套滑动
                startPos = true;
            }
            //重置一下 是否滚动模式
            scrollMode = 0;
        }
        return super.onInterceptTouchEvent(parent, child, ev);
    }

    @Override
    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View child, @NonNull View target, int dx, int dy, @NonNull int[] consumed, int type) {
        if (startPos) {
            if (scrollMode == 0) {
                if (child.getY() == headerHeight) {
                    //当list处于页面的顶部，需要根据滑动的方向来确定 是滚动模式还是嵌套滑动模式
                    if (dy > 0) {
                        //向上滑动 进入滚动模式
                        scrollMode = 1;
                    } else {
                        //向下滑动  进入嵌套滑动模式
                        scrollMode = -1;
                    }
                } else {
                    //当list不处于页面顶部，进入嵌套滑动模式
                    scrollMode = -1;
                }
            }
            //是滚动模式，不触发嵌套滑动 直接返回
            if (scrollMode > 0) return;
            if (dy > 0) {
                if (child.getY() > headerHeight) {
                    //只有未到达顶部  list才能嵌套滑动  不然滑不动界面
                    float targetPos = child.getY() - dy;
                    if (targetPos > headerHeight) {
                        child.setY(targetPos);
                    } else {
                        child.setY(headerHeight);
                    }
                }
            } else {
                if (child.getY() < searchBarHeight + headerHeight + bannerHeight) {
                    //只有未到达底部  list才能嵌套滑动  不然滑不动界面
                    float targetPos = child.getY() - dy;
                    if (targetPos < searchBarHeight + headerHeight + bannerHeight) {
                        child.setY(targetPos);
                    } else {
                        child.setY(searchBarHeight + headerHeight + bannerHeight);
                    }
                }
            }
            //嵌套滑动 无论什么情况 都要消费掉所有事件
            consumed[1] = dy;
        }
    }
}