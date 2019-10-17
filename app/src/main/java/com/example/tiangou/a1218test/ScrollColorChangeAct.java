package com.example.tiangou.a1218test;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

public class ScrollColorChangeAct extends AppCompatActivity {

    private View mColorView;
    private ViewPager mViewPager;

    private int mWidth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_color_change);

        mColorView = findViewById(R.id.color_view);
        mViewPager = (ViewPager) findViewById(R.id.view_pager);

        mViewPager.setAdapter(new ViewPagerAdapter(ScrollColorChangeAct.this));

        //android.util.Log.d("ScrollColorChangeAct",  "mWidth " + mWidth);


//        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//                //android.util.Log.d("ScrollColorChangeAct", "position " + position + " positionOffset " + positionOffset + " positionOffsetPixels " + positionOffsetPixels);
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
        MyPagerTransformer myPagerTransformer = new MyPagerTransformer(ScrollColorChangeAct.this, mColorView);
        mViewPager.addOnPageChangeListener(myPagerTransformer);
        mViewPager.setPageTransformer(true, myPagerTransformer);
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    public static class MyPagerTransformer implements ViewPager.PageTransformer, ViewPager.OnPageChangeListener{

        private Context mContext;
        private View mColorView;

        private int mPagerIndex;

        public MyPagerTransformer(Context context, View colorView) {
            this.mContext = context;
            this.mColorView = colorView;
        }

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            android.util.Log.d("ScrollColorChangeAct", "position " + position + " positionOffset " + positionOffset + " positionOffsetPixels " + positionOffsetPixels);

            int color0 = mContext.getResources().getColor(R.color.red);
            int color1 = mContext.getResources().getColor(R.color.green);
            int color2 = mContext.getResources().getColor(R.color.blue);

            int color = color0;

            ArgbEvaluator argbEvaluator = new ArgbEvaluator();

            switch (position) {
                case 0:
                    color = (int) argbEvaluator.evaluate(Math.abs(positionOffset), color0, color1);
                    break;
                case 1:
                    color = (int) argbEvaluator.evaluate(Math.abs(positionOffset), color1, color2);
                    break;
                case 2:
                    color = (int) argbEvaluator.evaluate(Math.abs(positionOffset), color2, color1);
                    break;
                default:
                    break;

            }

            mColorView.setBackgroundColor(color);
        }

        @Override
        public void onPageSelected(int position) {
            mPagerIndex = position;

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }

        @Override
        public void transformPage(View page, float position) {




        }
    }

    public static class ViewPagerAdapter extends PagerAdapter {

        private Context mContext;

        public ViewPagerAdapter(Context context) {
            this.mContext = context;
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View rootView = LayoutInflater.from(mContext).inflate(R.layout.view_pager_item_layout, container, false);

            TextView textView = (TextView) rootView.findViewById(R.id.textView);

            textView.setText(position + "");

            container.addView(rootView);

            return rootView;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }

    public int getDisplayW(Context context){

        int width = 0;

        WindowManager windowManager = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        if(displayMetrics.widthPixels > displayMetrics.heightPixels){
            width = displayMetrics.heightPixels;
        }
        else{
            width = displayMetrics.widthPixels;
        }
        return width;
    }
}
