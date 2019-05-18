package com.zequs.learn.designpatterns.singleton;

/**
 * 懒汉，安全
 */
public class LazySafeSingleton {
    private static LazySafeSingleton singleton ;

    private LazySafeSingleton() {}

    public synchronized LazySafeSingleton getInstance() {
        if (singleton == null) {
            singleton = new LazySafeSingleton();
        }

        return singleton;
    }

}
