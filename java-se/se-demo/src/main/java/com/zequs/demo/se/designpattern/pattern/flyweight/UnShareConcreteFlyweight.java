package com.zequs.demo.se.designpattern.pattern.flyweight;

/**
 * 没用到，很无奈。区别在类实现上。要用到这个的话，池中key需要是Flyweight。
 * 如果key的flyweight的实现是UnShareConcreteFlyweight的话就不保存到池子中
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 06 Exp $
 */
public class UnShareConcreteFlyweight extends Flyweight {
    private String type;

    public UnShareConcreteFlyweight(String type) {
        this.type = type;
    }

    @Override
    public void peration1() {
        System.out.println("不共享业务处理");
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
