package com.zequs.demo.se.designpattern.pattern.decorator.decorator;

import com.zequs.demo.se.designpattern.pattern.decorator.component.Drink;

/**
 * 糖
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 05 Exp $
 */
public class Sugar extends Decorator {

    public Sugar(Drink drink) {
        super(drink);
        setDescription("sugar");
        setPrice(1.0f);
    }
}
