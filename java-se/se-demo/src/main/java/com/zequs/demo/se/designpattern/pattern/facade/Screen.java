package com.zequs.demo.se.designpattern.pattern.facade;

/**
 * 屏幕
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 06 Exp $
 */
public class Screen {
    private final static Screen INSTANCE = new Screen();

    private Screen() {}

    public static Screen getInstance() {
        return INSTANCE;
    }

    public void up() {
        System.out.println("屏幕打开");
    }

    public  void down() {
        System.out.println("屏幕关上");
    }
}
