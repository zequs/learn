package com.zequs.demo.se.designpattern.pattern.composite;

/**
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 05 Exp $
 */
public class Client {
    public static void main(String[] args) {
        Component  composite = new Composite("集团公司","集团公司");
        Component  composite1 = new Composite("A子公司","A子公司");
        composite.add(composite1);
        Component  composite2 = new Composite("B子公司","B子公司");
        composite.add(composite2);
        Component  composite3 = new Composite("A子公司其下分公司","A子公司其下分公司");
        composite1.add(composite3);
        Component leaf = new Composite("A子公司销售部","A子公司销售部");
        composite1.add(leaf);
        Component leaf2 = new Composite("B子公司运营部","B子公司运营部");
        composite2.add(leaf2);
        Component leaf3 = new Composite("A子公司其下分公司客服部","A子公司其下分公司客服部");
        composite3.add(leaf3);
        composite.print();
    }
}
