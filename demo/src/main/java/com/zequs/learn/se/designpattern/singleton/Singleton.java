package com.zequs.learn.se.designpattern.singleton;

public class Singleton {
    private static Singleton singleton = new Singleton();

    public int a = 1;

    private Singleton(){

    }

    public static Singleton getInstance() {
        return  singleton;
    }
}
