package com.zequs.learn.se.designpattern.proxy;

public class User implements Person {
    @Override
    public void buyFood() {
        System.out.println("买米");
    }
}
