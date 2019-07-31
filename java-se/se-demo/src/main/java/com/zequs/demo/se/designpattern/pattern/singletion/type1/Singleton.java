package com.zequs.demo.se.designpattern.pattern.singletion.type1;

/**
 * 饿汉式-静态常量
 *
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 07 31 Exp $
 */
public class Singleton {

    private final static Singleton instance = new Singleton();

    //构造方法私有化
    private Singleton() {

    }

    public static Singleton getInstance() {
        return instance;
    }

    public static void main(String[] args) {

    }

}
