package com.example.tiangou.a1218test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class TextViewTestActivity extends AppCompatActivity {

    TextView textView1;
    TextView textView2;
    TextView textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view_test);

        textView1 = (TextView) findViewById(R.id.text1);
        textView2 = (TextView) findViewById(R.id.text2);
        textView3 = (TextView) findViewById(R.id.text3);

    }

    @Override
    protected void onResume() {
        super.onResume();
        textView1.measure(0, 0);
        textView2.measure(0, 0);
        textView3.measure(0, 0);
        Log.d("TextViewTestActivity", "textView1 width -> " + textView1.getMeasuredWidth());
        Log.d("TextViewTestActivity", "textView2 width -> " + textView2.getMeasuredWidth());
        Log.d("TextViewTestActivity", "textView3 width -> " + textView3.getMeasuredWidth());

    }
}
