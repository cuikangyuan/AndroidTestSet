package com.example.tiangou.a1218test.daggertest;

import javax.inject.Inject;
import javax.inject.Named;

public class Car {

    private Engine engine;

    @Inject
    public Car(@Diesel Engine engine) {

        this.engine = engine;
    }

    public String run() {
        return engine.work();
    }
}
