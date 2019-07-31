package com.zequs.demo.se.designpattern.pattern.singletion.type5;

/**
 * 懒汉式-线程不安全,同步代码块
 *
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 07 31 Exp $
 */
public class Singleton {

    private static Singleton instance =  null;

    private Singleton() {

    }

    public static Singleton getInstance() {
        //线程不安全
        if (instance == null) {
            synchronized (Singleton.class) {
                instance = new Singleton();
            }
        }
        return instance;
    }

    public static void main(String[] args) {

    }

}
