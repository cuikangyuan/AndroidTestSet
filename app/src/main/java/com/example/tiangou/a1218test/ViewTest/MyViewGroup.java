package com.example.tiangou.a1218test.ViewTest;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class MyViewGroup extends ViewGroup {

    public MyViewGroup(Context context) {
        this(context, null);
    }

    public MyViewGroup(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public MyViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);


        measureChildren(widthMeasureSpec, heightMeasureSpec);

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);

        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int childCount = getChildCount();

        if (childCount <= 0) {

            setMeasuredDimension(0, 0);

        } else {

            if (widthMode == MeasureSpec.AT_MOST
                && heightMode == MeasureSpec.AT_MOST) {

                int height = getTotalHeight();
                int width = getMaxChildWidth();
                setMeasuredDimension(width, height);

            } else if (heightMode == MeasureSpec.AT_MOST) {

                setMeasuredDimension(widthSize, getTotalHeight());

            } else if (widthMode == MeasureSpec.AT_MOST) {

                setMeasuredDimension(getMaxChildWidth(), heightSize);

            }

        }

    }

    private int getTotalHeight() {
        int result = 0;

        int childCount = getChildCount();

        for (int i = 0; i < childCount; i++) {
            View childView = getChildAt(i);
            result += childView.getMeasuredHeight();
        }


        return result;
    }

    private int getMaxChildWidth() {

        int result = 0;

        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childView = getChildAt(i);
            if (childView.getMeasuredWidth() > result) {

                result = childView.getMeasuredWidth();
            }
        }


        return result;

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

        int count = getChildCount();

        int curHeight = t;

        for (int i = 0; i < count; i++) {

            View child = getChildAt(i);

            int width = child.getWidth();
            int height = child.getHeight();

            child.layout(l, curHeight, l + width, curHeight + height);

            curHeight += height;

        }


    }
}
