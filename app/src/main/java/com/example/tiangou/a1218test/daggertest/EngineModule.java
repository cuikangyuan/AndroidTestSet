package com.example.tiangou.a1218test.daggertest;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class EngineModule {

    //通过@Name 提供不同的对象
//
////    @Provides
////    @Named("Gasoline")
////    public Engine provideGasolineEngine() {
////        return new GasolineEngine();
////    }
////
////    @Provides
////    @Named("Diesel")
////    public Engine provideDieselEngine() {
////        return new DieselEngine();
////    }

    //通过@Qualifier 提供不同的对象

    @Provides
    @Gasoline
    public Engine provideGasolineEngine() {
        return new GasolineEngine();
    }

    @Provides
    @Diesel
    public Engine provideDieselEngine() {
        return new DieselEngine();
    }
}
