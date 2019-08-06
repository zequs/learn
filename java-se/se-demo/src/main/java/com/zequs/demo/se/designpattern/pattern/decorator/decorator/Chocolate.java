package com.zequs.demo.se.designpattern.pattern.decorator.decorator;

import com.zequs.demo.se.designpattern.pattern.decorator.component.Drink;

/**
 * 巧克力
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 05 Exp $
 */
public class Chocolate  extends Decorator {

    public Chocolate(Drink drink) {
        super(drink);
        setDescription("Chocolate");
        setPrice(3.0f);
    }
}
