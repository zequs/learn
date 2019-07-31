package com.zequs.demo.se.designpattern.pattern.singletion.type2;

/**
 * 饿汉式-静态代码块
 *
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 07 31 Exp $
 */
public class Singleton {

    private static Singleton instance =  null;

    static {
        instance = new Singleton();
    }

    private Singleton() {

    }

    public static Singleton getInstance() {
        return instance;
    }

    public static void main(String[] args) {

    }

}
