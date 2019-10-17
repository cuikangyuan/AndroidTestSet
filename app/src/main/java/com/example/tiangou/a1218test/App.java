package com.example.tiangou.a1218test;

import android.app.Application;
import android.content.Context;

import com.example.tiangou.a1218test.daggertest.ActivityComponent;
import com.example.tiangou.a1218test.daggertest.DaggerActivityComponent;
import com.example.tiangou.a1218test.daggertest.DaggerSwordManComponent;

import retrofit2.Retrofit;

public class App extends Application {


    ActivityComponent activityComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        activityComponent = DaggerActivityComponent.builder()
                .swordManComponent(DaggerSwordManComponent.builder().build())
                .build();
    }

    public static App get(Context context) {
        return (App) context.getApplicationContext();
    }

    public ActivityComponent getActivityComponent() {
        return activityComponent;
    }
}
