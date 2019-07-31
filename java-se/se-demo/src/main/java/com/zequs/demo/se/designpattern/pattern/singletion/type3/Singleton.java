package com.zequs.demo.se.designpattern.pattern.singletion.type3;

/**
 * 懒汉式-线程不安全
 *
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 07 31 Exp $
 */
public class Singleton {

    private static Singleton instance =  null;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public static void main(String[] args) {

    }

}
