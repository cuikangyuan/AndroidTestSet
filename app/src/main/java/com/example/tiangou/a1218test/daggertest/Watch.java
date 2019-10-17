package com.example.tiangou.a1218test.daggertest;

import android.util.Log;

import javax.inject.Inject;

public class Watch {

    @Inject
    public Watch() {

    }

    public void work() {
        Log.d("wangshu", "手表");
    }
}
