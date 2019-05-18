package com.zequs.learn.designpatterns.singleton;

/**
 * 懒汉，不安全
 */
public class LazyUnsafeSingleton {
    private static LazyUnsafeSingleton singleton ;

    private LazyUnsafeSingleton() {}

    public LazyUnsafeSingleton getInstance() {
        if (singleton == null) {
            singleton = new LazyUnsafeSingleton();
        }

        return singleton;
    }

}
