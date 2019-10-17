package com.example.tiangou.a1218test.daggertest;



import dagger.Component;

@ApplicationScope
@Component(modules = {GsonModule.class, EngineModule.class})
public interface Main11ActivityComponent {

    void inject(Main11Activity main11Activity);
}
