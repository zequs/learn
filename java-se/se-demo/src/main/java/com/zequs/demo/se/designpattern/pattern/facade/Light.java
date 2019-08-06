package com.zequs.demo.se.designpattern.pattern.facade;

/**
 * 灯光
 *
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 06 Exp $
 */
public class Light {

    private final static Light INSTANCE = new Light();

    private Light() {}

    public static Light getInstance() {
        return INSTANCE;
    }

    public void on() {
        System.out.println("灯光开起来");
    }

    public void off() {
        System.out.println("灯光光掉了");
    }
}
