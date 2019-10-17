package com.example.tiangou.a1218test.startForResultTest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tiangou.a1218test.R;

public class Main4Activity extends AppCompatActivity {


    private Button mButton;

    private int requestCode = 999;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);


        mButton = (Button) findViewById(R.id.button);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Main5Activity.start(Main4Activity.this, requestCode);



                Main5Activity.start(Main4Activity.this, requestCode);


            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        android.util.Log.d("onActivityResult", "onActivityResult requestCode -> " + requestCode + " resultCode -> " + resultCode);


    }
}
