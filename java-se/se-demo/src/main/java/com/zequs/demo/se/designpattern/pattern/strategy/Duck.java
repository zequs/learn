package com.zequs.demo.se.designpattern.pattern.strategy;

/**
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 09 Exp $
 */
public abstract class Duck {
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public Duck() {
    }

    public void  fly() {
        flyBehavior.fly();
    }

    public void quack() {
        quackBehavior.quack();
    }
}
