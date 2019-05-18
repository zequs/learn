package com.zequs.learn.designpatterns.singleton;

/**
 * 双重检验线程安全。懒加载。调用的时候才去实例化
 * @link https://www.cnblogs.com/Ycheng/p/7169381.html
 */
public class DoubleVerificationSingleton {
    private DoubleVerificationSingleton() {}

    private volatile static  DoubleVerificationSingleton singleton;

    public DoubleVerificationSingleton getInstance() {
        if (singleton == null) {
            synchronized (DoubleVerificationSingleton.class) {
                if (singleton == null) {
                    singleton = new DoubleVerificationSingleton();
                }
            }

        }
        return  singleton;
    }
}
