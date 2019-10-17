package com.example.tiangou.a1218test.daggertest;

import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class GsonModule {

    @ApplicationScope
    @Provides
    public Gson provideGson() {
        return new Gson();
    }
}
