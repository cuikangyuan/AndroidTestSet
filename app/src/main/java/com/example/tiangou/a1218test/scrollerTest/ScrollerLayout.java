package com.example.tiangou.a1218test.scrollerTest;

import android.content.Context;
import android.support.v4.view.ViewConfigurationCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.Scroller;

public class ScrollerLayout extends ViewGroup {


    private Scroller mScroller;

    private int mTouchSlop;

    private float mXDown;
    private float mXMove;
    private float mXLastMove;

    private int leftBorder;
    private int rightBorder;

    public ScrollerLayout(Context context, AttributeSet attrs) {
        super(context, attrs);

        //step 1
        mScroller = new Scroller(context);
        ViewConfiguration configuration = ViewConfiguration.get(context);
        mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(configuration);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int childCount = getChildCount();

        for (int i = 0; i < childCount; i++) {
            View childView = getChildAt(i);

            measureChild(childView, widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

        if (changed) {

            int childCount = getChildCount();

            for (int i = 0; i < childCount; i++) {

                View childView = getChildAt(i);

                childView.layout(
                        i * childView.getMeasuredWidth(),
                        0,
                        (i + 1) * childView.getMeasuredWidth(),
                        childView.getMeasuredHeight()
                        );

                leftBorder = getChildAt(0).getLeft();
                rightBorder = getChildAt(childCount - 1).getRight();

            }

        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {

        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mXDown = ev.getRawX();
                mXLastMove = mXDown;
                break;
            case MotionEvent.ACTION_MOVE:
                mXMove = ev.getRawX();
                //TODO
                float diff = Math.abs(mXMove - mXDown);
                mXLastMove = mXMove;

                if (diff > mTouchSlop) {
                    return true;
                }

                break;

        }
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:
                mXMove = event.getRawX();
                int scrolledX = (int) (mXLastMove - mXMove);
                if (getScrollX() + scrolledX < leftBorder) {

                    scrollTo(leftBorder, 0);

                } else if (getScrollX() + scrolledX + getWidth() > rightBorder) {

                    scrollTo(rightBorder - getWidth(), 0);

                }
                scrollBy(scrolledX, 0);

                mXLastMove = mXMove;
                break;
            case MotionEvent.ACTION_UP:
                //手指抬起时 根据当时的滚动值来判定应该滑动到哪个子控件
                int targetIndex = (getScrollX() + getWidth() / 2) / getWidth();
                int dx = targetIndex * getWidth() - getScrollX();

                //step 2 调用startScroll() 方法初始化滚动数据并刷新页面
                mScroller.startScroll(getScrollX(), 0, dx, 0);
                invalidate();
                break;

        }

        return super.onTouchEvent(event);
    }

    @Override
    public void computeScroll() {
        //step 3 重写computeScroll() 方法 并在其内部完成平滑滚动的逻辑
        if (mScroller.computeScrollOffset()) {
            scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            invalidate();
        }
    }
}
