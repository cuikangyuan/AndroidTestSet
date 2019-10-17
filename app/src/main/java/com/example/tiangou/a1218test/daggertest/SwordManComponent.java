package com.example.tiangou.a1218test.daggertest;

import dagger.Component;

@Component(modules = SwordManModule.class)
public interface SwordManComponent {

    SwordMan getSwordMan();
}
