package com.example.tiangou.a1218test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    ScratchView scratchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        scratchView = (ScratchView) findViewById(R.id.scratch_view);

        scratchView.setmEraseStatusListener(new ScratchView.EraseStatusListener() {
            @Override
            public void onProgress(int percent) {
                android.util.Log.d("ScratchView", "onProgress  " + percent);
            }

            @Override
            public void onCompleted(View view) {
                android.util.Log.d("ScratchView", "onCompleted");

            }
        });
    }
}
