package com.zequs.demo.se.keyword.statickey;


import java.util.Calendar;

/**
 *  调用抽象方法的静态属性，静态方法，也会导致抽象类的初始化
 *
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 19 Exp $
 */
public class Test {
    public static void main(String[] args) {
//        Test test = new Test();
//        AbstractStaticTest.test();
//        AbstractStaticTest tt= new AbstractStaticTest();
        if (Calendar.getInstance().get(Calendar.DAY_OF_WEEK)  !=  1) {
            System.out.println(11);
        }
    }
}
