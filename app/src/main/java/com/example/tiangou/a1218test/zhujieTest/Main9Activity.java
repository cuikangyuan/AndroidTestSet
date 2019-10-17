package com.example.tiangou.a1218test.zhujieTest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.tiangou.a1218test.R;
import com.example.tiangou.annotations.BindView;

public class Main9Activity extends AppCompatActivity {


    @BindView(value = R.id.tv_text)
    TextView tv_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);
    }
}
