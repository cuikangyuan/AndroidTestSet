package com.example.tiangou.a1218test.daggertest;


import dagger.Component;

@ApplicationScope
@Component(modules = {GsonModule.class, EngineModule.class}, dependencies = SwordManComponent.class)
public interface ActivityComponent {

    void inject(Main11Activity main11Activity);

    void inject(Main12Activity main12Activity);

}
