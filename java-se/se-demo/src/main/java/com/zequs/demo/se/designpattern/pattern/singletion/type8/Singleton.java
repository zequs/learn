package com.zequs.demo.se.designpattern.pattern.singletion.type8;

/**
 * 枚举
 * 优点：不会被反射，克隆破坏单例
 * https://blog.csdn.net/u010002184/article/details/90759162
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 07 31 Exp $
 */
public enum Singleton {
    INSTANCE;

    public static void main(String[] args) {
        Singleton singleton1 = Singleton.INSTANCE;
        Singleton singleton2 = Singleton.INSTANCE;
        System.out.println(singleton1 == singleton2);
    }
}
