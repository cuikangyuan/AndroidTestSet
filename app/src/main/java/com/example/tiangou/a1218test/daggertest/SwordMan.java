package com.example.tiangou.a1218test.daggertest;

import com.example.tiangou.a1218test.zhujieTest.Swordsman;

import javax.inject.Inject;

public class SwordMan {


    @Inject
    public SwordMan() {

    }

    public String fighting() {

        return "比武";
    }
}
