package com.zequs.demo.se.designpattern.pattern.strategy;

/**
 * 北京鸭
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 09 Exp $
 */
public class PekingDuck extends  Duck {
    public PekingDuck() {
        flyBehavior = new BadFlyBehavior();
        quackBehavior = new GaGaQuackBehavior();
    }
}
