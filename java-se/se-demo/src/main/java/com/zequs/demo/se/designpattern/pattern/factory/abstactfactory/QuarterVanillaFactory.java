package com.zequs.demo.se.designpattern.pattern.factory.abstactfactory;

/**
 *
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 07 31 Exp $
 */
public class QuarterVanillaFactory implements PizzaFactory {

    //这边也可以使用简单工厂模式
    @Override
    public Bake getbake() {
        return new QuarterBake();
    }

    //这边也可以使用简单工厂模式
    @Override
    public Ingredient SelectionIngredient() {
        return new VanillaIngredient();
    }
}
