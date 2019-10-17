package com.example.tiangou.a1218test.EventBusTest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.tiangou.a1218test.R;

import org.greenrobot.eventbus.EventBus;

public class Main6Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        EventBus.getDefault().register(Main6Activity.this);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        EventBus.getDefault().register(Main6Activity.this);

    }
}
