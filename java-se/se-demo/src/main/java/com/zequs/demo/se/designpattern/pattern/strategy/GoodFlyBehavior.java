package com.zequs.demo.se.designpattern.pattern.strategy;

/**
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 09 Exp $
 */
public class GoodFlyBehavior extends  FlyBehavior {
    @Override
    public void fly() {
        System.out.println("天空霸者，翱翔整个天空");
    }
}
