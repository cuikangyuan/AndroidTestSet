package com.example.tiangou.a1218test.daggertest;


import com.example.tiangou.a1218test.zhujieTest.Swordsman;

import dagger.Module;
import dagger.Provides;

@Module
public class SwordManModule {

    @Provides
    public SwordMan provideSwordMan() {
        return new SwordMan();
    }
}
