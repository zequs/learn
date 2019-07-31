package com.zequs.demo.se.designpattern.pattern.factory.factorymethod;

/**
 * 工厂方法
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 07 31 Exp $
 */
public class Test {
    public static void main(String[] args) {
        Pizza BJpizza = new BJFactory().create();
        BJpizza.work();
        Pizza ZJpizza = new ZJFactory().create();
        ZJpizza.work();
    }
}
