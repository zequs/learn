package com.zequs.demo.se.keyword.statickey;

/**
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 19 Exp $
 */
public abstract class AbstractStaticTest {
    static {
        System.out.println("AbstractStaticTest init");
    }

    public static void test() {
        System.out.println("AbstractStaticTest#test");
    }
}