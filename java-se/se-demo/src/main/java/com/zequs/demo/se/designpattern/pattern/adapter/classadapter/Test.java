package com.zequs.demo.se.designpattern.pattern.adapter.classadapter;

/**
 * 类适配模式，适配器继承被适配类
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 01 Exp $
 */
public class Test {
    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.charging(new ClassAdapter());
    }
}
