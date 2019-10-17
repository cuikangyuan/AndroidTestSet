package com.example.tiangou.a1218test.OttoTest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tiangou.a1218test.R;
import com.squareup.otto.Produce;

public class Main8Activity extends AppCompatActivity {

    private Button button;

    private OttoBus bus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);

        button = (Button) findViewById(R.id.button_1);

        OttoBus.getInstance().register(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                OttoBus.getInstance().post(new BusData("事件消息"));

                Main8Activity.this.finish();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        OttoBus.getInstance().unregister(this);

    }

    @Produce
    public BusData produceBusData() {
        return new BusData("Product Bus Data");
    }
}
