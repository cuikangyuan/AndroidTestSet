package com.example.tiangou.a1218test.butterknifetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.example.tiangou.a1218test.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main10Activity extends AppCompatActivity {

    @BindView(R.id.button_1)
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);

        ButterKnife.bind(Main10Activity.this);
    }
}
