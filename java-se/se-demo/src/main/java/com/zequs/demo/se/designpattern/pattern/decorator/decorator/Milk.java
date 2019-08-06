package com.zequs.demo.se.designpattern.pattern.decorator.decorator;

import com.zequs.demo.se.designpattern.pattern.decorator.component.Drink;

/**
 * 牛奶
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 05 Exp $
 */
public class Milk extends Decorator {

    public Milk(Drink drink) {
        super(drink);
        setDescription("milk");
        setPrice(2.0f);
    }
}
