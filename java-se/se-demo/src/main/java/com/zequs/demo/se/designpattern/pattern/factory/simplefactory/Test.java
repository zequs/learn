package com.zequs.demo.se.designpattern.pattern.factory.simplefactory;

/**
 * 简单工厂
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 07 31 Exp $
 */
public class Test {
    public static void main(String[] args) {
        Pizza pizza = SimpleFactory.crete("Vanilla");
        pizza.work();
    }
}
