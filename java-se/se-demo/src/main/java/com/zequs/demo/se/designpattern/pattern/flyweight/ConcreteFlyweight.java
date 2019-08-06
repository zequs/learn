package com.zequs.demo.se.designpattern.pattern.flyweight;

/**
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 06 Exp $
 */
public class ConcreteFlyweight extends Flyweight {
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ConcreteFlyweight(String type) {
        this.type = type;
    }

    @Override
    public void peration1() {
        System.out.println("共享业务处理");
    }
}
