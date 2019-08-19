package com.zequs.demo.se.designpattern.pattern.strategy;

/**
 * 策略模式
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 09 Exp $
 */
public class Client {


    public static void main(String[] args) {
        Duck pekingDuck = new PekingDuck();
        pekingDuck.fly();

        Duck wildDuck = new WildDuck();
        wildDuck.fly();
        wildDuck.quack();

    }
}
