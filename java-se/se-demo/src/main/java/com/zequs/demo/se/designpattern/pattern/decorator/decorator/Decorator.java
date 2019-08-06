package com.zequs.demo.se.designpattern.pattern.decorator.decorator;

import com.zequs.demo.se.designpattern.pattern.decorator.component.Drink;

/**
 * 装饰者
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 05 Exp $
 */
public class Decorator extends Drink {

    private Drink obj;

    public Decorator(Drink drink) {
        this.obj = drink;
    }

    @Override
    public float cost() {
        return this.getPrice() + obj.cost();
    }

    @Override
    public String getDescription() {
        return  "aaaaaaaa1"+obj.getDescription() + "," + super.getDescription() + ":" + super.getPrice();
    }
}
