package com.example.tiangou.a1218test.daggertest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.tiangou.a1218test.App;
import com.example.tiangou.a1218test.R;
import com.google.gson.Gson;

import javax.inject.Inject;

public class Main12Activity extends AppCompatActivity {

    @Inject
    Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main12);

        App.get(this).getActivityComponent().inject(this);



        Log.d("wangshu", "Main12Activity " + gson.hashCode());

    }
}
