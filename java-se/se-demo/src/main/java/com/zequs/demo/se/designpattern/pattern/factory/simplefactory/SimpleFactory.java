package com.zequs.demo.se.designpattern.pattern.factory.simplefactory;

/**
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 07 31 Exp $
 */
public class SimpleFactory {

    public static Pizza crete(String name) {
        Pizza pizza = null;
        if (name.equals("strawberry")) {
            pizza = new StrawberryPizza();
        } else if (name.equals("Vanilla")) {
            pizza = new VanillaPizza();
        } else {
            System.out.println("无法制作这种披萨");
        }
        return pizza;
    }
}
