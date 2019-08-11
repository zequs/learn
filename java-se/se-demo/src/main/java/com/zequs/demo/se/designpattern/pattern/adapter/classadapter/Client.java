package com.zequs.demo.se.designpattern.pattern.adapter.classadapter;

/**
 * 类适配模式，适配器继承被适配类
 * 被适配类：Voltage220V
 * 适配类：IVoltage5V
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 01 Exp $
 */
public class Client {
    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.charging(new ClassAdapter());
    }
}
