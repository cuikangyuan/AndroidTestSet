package com.example.tiangou.a1218test.daggertest;

import javax.inject.Inject;

public class GasolineEngine extends Engine {

    @Inject
    public GasolineEngine() {

    }

    @Override
    public String work() {
        return "汽油机";
    }
}
