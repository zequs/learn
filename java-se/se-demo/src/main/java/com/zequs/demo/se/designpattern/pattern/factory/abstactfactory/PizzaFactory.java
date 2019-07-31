package com.zequs.demo.se.designpattern.pattern.factory.abstactfactory;

/**
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 07 31 Exp $
 */
interface PizzaFactory {
    public Ingredient SelectionIngredient();
    public Bake getbake();
}
