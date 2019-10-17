package com.example.tiangou.a1218test.ViewTest;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.tiangou.a1218test.R;

public class MyView extends View {

    private int defaultSize;

    public MyView(Context context) {
        this(context, null);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);


        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyView);


        defaultSize = typedArray.getDimensionPixelSize(R.styleable.MyView_default_size, 200);


        typedArray.recycle();
    }


    private int getMySize(int defaultSize, int measureSpec) {


        int result = defaultSize;


        int mode = MeasureSpec.getMode(measureSpec);
        int size = MeasureSpec.getSize(measureSpec);

        switch (mode) {
            case MeasureSpec.UNSPECIFIED:
                result = defaultSize;
                break;
            case MeasureSpec.AT_MOST:
                result = size;
                break;
            case MeasureSpec.EXACTLY:
                result =  size;
                break;


        }


        return result;

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int width = getMySize(defaultSize, widthMeasureSpec);
        int height = getMySize(defaultSize, heightMeasureSpec);

        if (width < height) {

            height = width;

        } else {

            width = height;
        }

        setMeasuredDimension(width, height);

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int r = getMeasuredWidth() / 2;

        int centerX = getLeft() + r;

        int centerY = getTop() + r;

        Paint paint = new Paint();
        paint.setColor(Color.GRAY);

        canvas.drawCircle(centerX, centerY, r, paint);

    }
}
