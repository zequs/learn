package com.zequs.demo.se.designpattern.pattern.strategy;

/**
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 09 Exp $
 */
public class NoFlyBehavior extends FlyBehavior {
    @Override
    public void fly() {
        System.out.println("飞不了呀");
    }
}
