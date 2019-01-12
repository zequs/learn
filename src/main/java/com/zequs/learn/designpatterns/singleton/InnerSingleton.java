package com.zequs.learn.designpatterns.singleton;

/**
 * 内部类，线程安全，懒加载。
 */
public class InnerSingleton {
    private InnerSingleton() {}

    private static class inner{
        private static final InnerSingleton innerSingleton = new InnerSingleton();
    }

    public InnerSingleton getInstance() {
        return inner.innerSingleton;
    }
}
