package com.example.tiangou.a1218test.zhujieTest;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Swordsman {

    String name() default "defaultName";
    int age() default -1;
}
