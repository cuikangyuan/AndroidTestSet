package com.example.tiangou.a1218test.zhujieTest;


public class AnnotationTest {


    @GET(value = "http://123.com")
    public String getIpMsg() {
        return "";
    }

    @GET(value = "http://456.com")
    public String getIp() {
        return "";
    }
}
