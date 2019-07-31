package com.zequs.demo.se.designpattern.pattern.factory.factorymethod;

/**
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 07 31 Exp $
 */
public class StrawberryPizza implements Pizza {
    @Override
    public void work() {
        System.out.println("-----制作草莓披萨-----");
    }
}
