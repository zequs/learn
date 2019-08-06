package com.zequs.demo.se.designpattern.pattern.decorator.component;

/**
 * 意大利咖啡
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 05 Exp $
 */
public class Espresso extends Coffer {

    public Espresso () {
        this.setDescription("Espresso Coffer");
        this.setPrice(5.0f);
    }
}
