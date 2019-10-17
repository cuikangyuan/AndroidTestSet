package com.example.tiangou.a1218test;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

public class ScratchView extends View {

    private int mMaskColor;
    private Paint mMaskPaint;
    private Bitmap mMaskBitmap;
    private Canvas mMaskCanvas;

    private float mEraseSize;
    private Paint mErasePaint;
    private Path mErasePath;

    private int mTouchSlop;

    private float mStartX;
    private float mStartY;

    private BitmapDrawable mWatermark = null;

    private int mWatermarkResId = -1;

    private int mMaxPercent = 0;
    private int mPercent = 0;
    private boolean mIsCompleted = false;

    private static final int DEFAULT_MASKER_COLOR = 0;

    private static final int DEFAULT_ERASE_SIZE = 60;

    private final static int DEFAULT_PERCENT = 70;


    private EraseStatusListener mEraseStatusListener;

    public ScratchView(Context context) {
        this(context, null);
    }

    public ScratchView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ScratchView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ScratchView);

        init(typedArray);
    }

    private void init(TypedArray typedArray) {

        mMaskColor = typedArray.getColor(R.styleable.ScratchView_maskColor, DEFAULT_MASKER_COLOR);

        mEraseSize = typedArray.getDimensionPixelOffset(R.styleable.ScratchView_eraseSize, DEFAULT_ERASE_SIZE);

        mWatermarkResId = typedArray.getResourceId(R.styleable.ScratchView_waterMarkResId, -1);

        mMaxPercent = typedArray.getInt(R.styleable.ScratchView_maxPercent, DEFAULT_PERCENT);

        mMaskPaint = new Paint();
        mMaskPaint.setAntiAlias(true);// 抗锯齿
        mMaskPaint.setDither(true);//防抖

        mErasePaint = new Paint();
        mErasePaint.setAntiAlias(true);
        mErasePaint.setDither(true);
        mErasePaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));//设置擦除效果
        mErasePaint.setStyle(Paint.Style.STROKE);
        mErasePaint.setStrokeCap(Paint.Cap.ROUND);//设置笔尖形状，让绘制的边缘圆滑
        mErasePaint.setStrokeWidth(mEraseSize);

        mErasePath = new Path();


        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        mTouchSlop = viewConfiguration.getScaledTouchSlop();


        setmMaskColor(mMaskColor);

        setWatermark(mWatermarkResId);

    }

    public void setmEraseSize(float eraseSize) {

        mErasePaint.setStrokeWidth(eraseSize);
    }

    public void setmMaskColor(int color) {
        mMaskPaint.setColor(color);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawBitmap(mMaskBitmap, 0, 0, mMaskPaint);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        createMasker(w, h);
    }

    //创建蒙层
    private void createMasker(int width, int height) {

        mMaskBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);

        mMaskCanvas = new Canvas(mMaskBitmap);
        Rect rect = new Rect(0, 0, width, height);

        mMaskCanvas.drawRect(rect, mMaskPaint); //绘制生成和控件大小一致的遮罩 Bitmap

        if (mWatermark != null) {

            Rect bounds = new Rect(rect);
            mWatermark.setBounds(bounds);
            mWatermark.draw(mMaskCanvas);
        }
    }

    public void setWatermark(int resId) {
        if (resId == -1) {

            mWatermark = null;

        } else {

            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), resId);
            mWatermark = new BitmapDrawable(bitmap);
            mWatermark.setTileModeXY(
                    Shader.TileMode.REPEAT,
                    Shader.TileMode.REPEAT
                    );
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int action = event.getAction();

        switch (action) {
            case MotionEvent.ACTION_DOWN:
                startErase(event.getX(), event.getY());
                invalidate();
                return true;
            case MotionEvent.ACTION_MOVE:
                erase(event.getX(), event.getY());
                invalidate();
                return true;
            case MotionEvent.ACTION_UP:
                stopErase();
                invalidate();
                return true;
            default:
                break;
        }


        return super.onTouchEvent(event);
    }


    private void startErase(float x, float y) {

        mErasePath.reset();
        mErasePath.moveTo(x, y);

        mStartX = x;
        mStartY = y;
    }

    private void erase(float x, float y) {

        int dx = (int) (Math.abs(x - mStartX));
        int dy = (int) (Math.abs(y - mStartY));

        if (dx >= mTouchSlop || dy >= mTouchSlop) {

            this.mStartX = x;
            this.mStartY = y;

            mErasePath.lineTo(x, y);
            mMaskCanvas.drawPath(mErasePath, mErasePaint);

            updateErasePercent();

            mErasePath.reset();
            mErasePath.moveTo(mStartX, mStartY);

        }

    }

    private void stopErase() {

        this.mStartX = 0;
        this.mStartY = 0;

        mErasePath.reset();

        updateErasePercent();
    }

    private void updateErasePercent() {
        int width = getWidth();
        int height = getHeight();

        new AsyncTask<Integer, Integer, Boolean>() {

            @Override
            protected void onProgressUpdate(Integer... values) {
                super.onProgressUpdate(values);

                mPercent = values[0];

                onPercentUpdate();

            }

            @Override
            protected void onPostExecute(Boolean result) {
                super.onPostExecute(result);

                if (result
                        && !mIsCompleted) {

                    mIsCompleted = true;

                    if (mEraseStatusListener != null) {
                        mEraseStatusListener.onCompleted(ScratchView.this);
                    }

                }
            }

            @Override
            protected Boolean doInBackground(Integer... integers) {

                int width = integers[0];
                int height = integers[1];

                int pixels[] = new int[width * height];

                mMaskBitmap.getPixels(pixels,
                        0,
                        width,
                        0,
                        0,
                        width,
                        height);

                float erasePixelCount = 0;
                float totalPixelCount = width * height;

                for (int index = 0;
                     index < totalPixelCount;
                     index++) {

                    if (pixels[index] == 0) {
                        //透明像素
                        erasePixelCount++;
                    }

                }

                int percent = 0;

                if (erasePixelCount > 0
                        && totalPixelCount > 0) {

                    percent = Math.round(erasePixelCount * 100 / totalPixelCount);

                    publishProgress(percent);
                }

                return percent >= mMaxPercent;
            }
        }.execute(width, height);
    }

    public void setmEraseStatusListener(EraseStatusListener mEraseStatusListener) {
        this.mEraseStatusListener = mEraseStatusListener;
    }

    private void onPercentUpdate() {
        if (mEraseStatusListener != null) {
            mEraseStatusListener.onProgress(mPercent);
        }
    }

    public static interface EraseStatusListener {
        public void onProgress(int percent);

        public void onCompleted(View view);
    }

    /**
     * 重置为初始状态
     */
    public void reset() {
        mIsCompleted = false;

        int width = getWidth();
        int height = getHeight();
        createMasker(width, height);
        invalidate();

        updateErasePercent();
    }

    /**
     * 清除整个图层
     */
    public void clear() {
        int width = getWidth();
        int height = getHeight();
        mMaskBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        mMaskCanvas = new Canvas(mMaskBitmap);
        Rect rect = new Rect(0, 0, width, height);
        mMaskCanvas.drawRect(rect, mErasePaint);
        invalidate();

        updateErasePercent();
    }
}
