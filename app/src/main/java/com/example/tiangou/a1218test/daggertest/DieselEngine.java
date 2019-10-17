package com.example.tiangou.a1218test.daggertest;

import javax.inject.Inject;

public class DieselEngine extends Engine {

    @Inject
    public DieselEngine() {

    }

    @Override
    public String work() {
        return "电动机";
    }
}
