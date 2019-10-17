package com.example.tiangou.a1218test.OttoTest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.tiangou.a1218test.R;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

public class Main7Activity extends AppCompatActivity {


    private TextView textView;
    private Button button;

    private OttoBus bus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        textView = (TextView) findViewById(R.id.text_1);
        button = (Button) findViewById(R.id.button_1);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main7Activity.this, Main8Activity.class));
            }
        });

        bus = OttoBus.getInstance();
        bus.register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bus.unregister(this);
    }


    @Subscribe
    public void setContent(BusData busData) {
        textView.setText(busData.message);
    }
}
