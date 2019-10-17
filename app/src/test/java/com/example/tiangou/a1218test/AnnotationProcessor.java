package com.example.tiangou.a1218test;

import com.example.tiangou.a1218test.zhujieTest.AnnotationTest;
import com.example.tiangou.a1218test.zhujieTest.GET;

import org.junit.Test;

import java.lang.reflect.Method;

public class AnnotationProcessor {

    @Test
    public void main() {

        Method[] methods = AnnotationTest.class.getDeclaredMethods();

        for (Method m : methods) {

            GET get = m.getAnnotation(GET.class);

            System.out.println(get.value());
        }

    }
}
