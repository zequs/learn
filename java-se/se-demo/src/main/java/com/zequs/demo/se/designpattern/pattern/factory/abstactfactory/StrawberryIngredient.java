package com.zequs.demo.se.designpattern.pattern.factory.abstactfactory;

/**
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 07 31 Exp $
 */
public class StrawberryIngredient implements Ingredient {
    @Override
    public void selection() {
        System.out.println("选择草莓配料");
    }
}
