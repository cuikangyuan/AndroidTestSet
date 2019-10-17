package com.example.tiangou.a1218test.scrollerTest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.tiangou.a1218test.R;

public class MainActivity extends AppCompatActivity {

    private LinearLayout layout;

    private Button scrollToButton;

    private Button scrollByButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        layout = (LinearLayout) findViewById(R.id.layout);
        scrollToButton = (Button) findViewById(R.id.scroll_to_btn);
        scrollByButton = (Button) findViewById(R.id.scroll_by_btn);


        scrollToButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout.scrollTo(-60, -100);
            }
        });

        scrollByButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout.scrollBy(-60, -100);
            }
        });


    }
}
