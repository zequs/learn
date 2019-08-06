package com.zequs.demo.se.designpattern.pattern.decorator.component;

/**
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 05 Exp $
 */
public class Coffer extends Drink {

    @Override
    public float cost() {
        return super.getPrice();
    }
}
