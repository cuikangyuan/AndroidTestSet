package com.example.tiangou.a1218test;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewTestAct extends AppCompatActivity {


    private RecyclerView mRecyclerView;

    private List<String> mData;

    private Button mButton;

    private RecyclerView.SmoothScroller mSmoothScroller;

    private LinearLayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_test);


        mButton = (Button) findViewById(R.id.button);

        mData = new ArrayList<>();

        for (int i=0; i<200; i++) {
            mData.add(i + "");

        }

        mLayoutManager = new LinearLayoutManager(RecyclerViewTestAct.this);

        mSmoothScroller = new LinearSmoothScroller(RecyclerViewTestAct.this) {
            @Override protected int getVerticalSnapPreference() {
                return LinearSmoothScroller.SNAP_TO_START;
            }

            @Override
            public int calculateDtToFit(int viewStart, int viewEnd, int boxStart, int boxEnd, int snapPreference) {

                if (snapPreference == SNAP_TO_START) {

                    mButton.setText((boxStart - viewStart) + "");

                    return boxStart - viewStart;

                } else {

                    return super.calculateDtToFit(viewStart, viewEnd, boxStart, boxEnd, snapPreference);
                }

            }

            @Override
            public PointF computeScrollVectorForPosition(int targetPosition) {
                PointF pointF = mLayoutManager.computeScrollVectorForPosition(targetPosition);
                return pointF;
            }

        };


        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        //mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL));

        mRecyclerView.setLayoutManager(mLayoutManager);

        mRecyclerView.setAdapter(new RvAdapter(RecyclerViewTestAct.this, mData));

        //mRecyclerView.addItemDecoration(new DividerGrid);

        //mRecyclerView.setAdapter();

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mSmoothScroller.setTargetPosition(40);
                mLayoutManager.startSmoothScroll(mSmoothScroller);
            }
        });
    }

    public static class  RvItemViewHolder extends RecyclerView.ViewHolder {

        private Context mContext;

        private TextView mText;

        public RvItemViewHolder(Context context, View itemView) {
            super(itemView);

            mText = (TextView) itemView.findViewById(R.id.text);
        }
    }

    public static class RvAdapter extends RecyclerView.Adapter {

        private Context mContext;
        private List<String> mData;

        public RvAdapter(Context context, List<String> data) {
            this.mContext = context;
            this.mData = data;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View itemView = LayoutInflater.from(mContext).inflate(R.layout.recycler_view_item_layout, parent, false);

            return new RvItemViewHolder(mContext, itemView);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

            ((RvItemViewHolder)holder).mText.setText(mData.get(position));

        }

        @Override
        public int getItemCount() {
            if (mData != null) {
                return mData.size();
            }
            return 0;
        }
    }
}
