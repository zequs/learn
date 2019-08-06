package com.zequs.demo.se.designpattern.pattern.builder;

/**
 * 抽象建造者
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 01 Exp $
 */
public abstract class HouseBuilder {
    protected  House house = new House();

    public abstract void  buiildBiase();
    public abstract void  buiildWall();
    public abstract void  roofed();

    public House buildHouse() {
        return house;
    }
}
