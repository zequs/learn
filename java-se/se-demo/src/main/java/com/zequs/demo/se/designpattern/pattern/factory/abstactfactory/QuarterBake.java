package com.zequs.demo.se.designpattern.pattern.factory.abstactfactory;

/**
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 07 31 Exp $
 */
public class QuarterBake implements Bake {
    @Override
    public void time() {
        System.out.println("烹饪15分钟");
    }
}
