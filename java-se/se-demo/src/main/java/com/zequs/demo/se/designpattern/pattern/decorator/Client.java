package com.zequs.demo.se.designpattern.pattern.decorator;

import com.zequs.demo.se.designpattern.pattern.decorator.component.Drink;
import com.zequs.demo.se.designpattern.pattern.decorator.component.ShortBlack;
import com.zequs.demo.se.designpattern.pattern.decorator.decorator.Chocolate;
import com.zequs.demo.se.designpattern.pattern.decorator.decorator.Milk;
import com.zequs.demo.se.designpattern.pattern.decorator.decorator.Sugar;

/**
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 05 Exp $
 */
public class Client {
    public static void main(String[] args) {
        Drink order = new ShortBlack();
        System.out.println("1:" +order.cost());

        order = new Milk(order);
        System.out.println("2:" +order.cost());
        System.out.println(order.getDescription());

        order = new Milk(order);
        System.out.println("3:" +order.cost());
        System.out.println(order.getDescription());
//        drink = new Milk(drink);
        order = new Sugar(order);
        System.out.println("4:" +order.cost());
        System.out.println(order.getDescription());
    }
}
