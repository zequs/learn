package com.zequs.demo.se.designpattern.pattern.factory.factorymethod;

/**
 * 北京披萨，生产香草披萨
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 07 31 Exp $
 */
public class BJFactory implements PizzaFactory{
    @Override
    public Pizza create() {
        System.out.println("选择北京工厂");
        return new VanillaPizza();
    }
}
