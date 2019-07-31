package com.zequs.demo.se.designpattern.pattern.singletion.type7;

/**
 * 静态内部类
 *
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 07 31 Exp $
 */
public class Singleton {

    private Singleton() {}

    //私有静态内部类
    //外部类被装载的时候，内部类不会被装载。--懒加载
    //内部类被装载的时候，classloader会处理同步问题 --线程同步
    private static class SingletInstance {
        private final static Singleton INSTANCE = new Singleton();

    }

    public static Singleton getInstance() {
        return new SingletInstance().INSTANCE;
    }
}
