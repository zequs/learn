package com.zequs.demo.se.designpattern.pattern.factory.abstactfactory;

/**
 * 抽象工厂是工厂方法的一个变种，产品多样化。
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 07 31 Exp $
 */
public class Test {
    public static void main(String[] args) {
        PizzaFactory factory = new SemihStrawberryFactory();
        factory.SelectionIngredient().selection();
        factory.getbake().time();

        PizzaFactory factory2 = new QuarterVanillaFactory();
        factory2.SelectionIngredient().selection();
        factory2.getbake().time();
    }
}
