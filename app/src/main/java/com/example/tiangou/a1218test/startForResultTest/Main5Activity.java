package com.example.tiangou.a1218test.startForResultTest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tiangou.a1218test.R;

public class Main5Activity extends AppCompatActivity {


    private Button mButton;


    public static void start(Activity context, int requestCoe) {

        Intent intent = new Intent(context, Main5Activity.class);

        context.startActivityForResult(intent, requestCoe);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        mButton = (Button) findViewById(R.id.button);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setResult(RESULT_OK);

                Main5Activity.this.finish();
            }
        });
    }
}
