package com.zequs.learn.designpatterns.singleton;

/**
 * 饿汉，安全,初始化时实例化了
 */
public class HungrySafeSingleton {

    private static HungrySafeSingleton safeSingleton = new HungrySafeSingleton();

    private  HungrySafeSingleton() {}

    public HungrySafeSingleton getInstance() {
        return  safeSingleton;
    }
}
