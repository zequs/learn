package com.zequs.demo.se.designpattern.pattern.factory.abstactfactory;

/**
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 07 31 Exp $
 */
public class SemihStrawberryFactory implements PizzaFactory {
    @Override
    public Bake getbake() {
        return new SemihBake();
    }

    @Override
    public Ingredient SelectionIngredient() {
        return new StrawberryIngredient();
    }
}
