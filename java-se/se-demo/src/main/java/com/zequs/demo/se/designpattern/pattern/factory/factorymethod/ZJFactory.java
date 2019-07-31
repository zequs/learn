package com.zequs.demo.se.designpattern.pattern.factory.factorymethod;

/**
 * 浙江工厂生产草莓披萨
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 07 31 Exp $
 */
public class ZJFactory implements PizzaFactory{
    @Override
    public Pizza create() {
        System.out.println("选择浙江工厂");
        return new StrawberryPizza();
    }
}
