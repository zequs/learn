package com.zequs.demo.se.designpattern.pattern.strategy;

/**
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 09 Exp $
 */
public class GaGaQuackBehavior extends QuackBehavior {

    @Override
    public void quack() {
        System.out.println("嘎嘎叫——————");
    }
}
