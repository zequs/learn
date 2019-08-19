package com.zequs.demo.se.designpattern.pattern.strategy;

/**
 * 野鸭
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 09 Exp $
 */
public class WildDuck extends Duck {

    public WildDuck() {
        flyBehavior = new BadFlyBehavior();
        quackBehavior = new GuGuQuackBehavior();
    }

}
