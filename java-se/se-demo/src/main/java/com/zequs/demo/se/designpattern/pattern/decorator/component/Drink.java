package com.zequs.demo.se.designpattern.pattern.decorator.component;

/**
 * Component 主体
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 05 Exp $
 */
public abstract class Drink {

    private String description;

    private float price;

    public abstract float cost();

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
