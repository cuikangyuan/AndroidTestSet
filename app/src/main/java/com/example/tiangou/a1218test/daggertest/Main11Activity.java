package com.example.tiangou.a1218test.daggertest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.tiangou.a1218test.App;
import com.example.tiangou.a1218test.R;
import com.google.gson.Gson;

import javax.inject.Inject;

import dagger.Lazy;


public class Main11Activity extends AppCompatActivity {

    @Inject
    Watch watch;

    @Inject
    Gson gson;

    @Inject
    Gson gson1;

    @Inject
    Car car;

    @Inject
    SwordMan swordMan;

    @Inject
    Lazy<SwordMan> swordMan2;

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main11);

        //DaggerMain11ActivityComponent.create().

        //DaggerMain11ActivityComponent.create().inject(this);

        App.get(this).getActivityComponent().inject(this);

        //watch.work();


        String jsonData = "{'name':'zhangwuji', 'age': 20}";

        Man man = gson.fromJson(jsonData, Man.class);


        //Log.d("wangshu", "name " + man.getName());

        car.run();

        Log.d("wangshu", "car run " + car.run());

        Log.d("wangshu", "Main11Activity " + gson.hashCode() + "-----" +  gson1.hashCode());

        Log.d("wangshu", "Main11Activity swordMan " + swordMan.fighting());


        Log.d("wangshu", "Main11Activity swordMan2 " + swordMan2.get().fighting());


        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main11Activity.this, Main12Activity.class);

                startActivity(intent);
            }
        });
    }

}
