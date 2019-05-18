package com.zequs.learn.designpatterns.proxy;

public class SuperMan implements User {
    @Override
    public void sayHello() {
        System.out.println("flying say hello");
    }
}
