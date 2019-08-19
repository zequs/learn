package com.zequs.demo.se.designpattern.pattern.strategy;

/**
 * 玩具鸭
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 09 Exp $
 */
public class ToyDuck extends  Duck {

    public ToyDuck() {
        flyBehavior = new NoFlyBehavior();
        quackBehavior = new GaGaQuackBehavior();
    }

}
