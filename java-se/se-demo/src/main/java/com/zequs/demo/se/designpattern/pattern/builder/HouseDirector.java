package com.zequs.demo.se.designpattern.pattern.builder;

/**
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 01 Exp $
 */
public class HouseDirector {
    HouseBuilder houseBuilder;

    public HouseDirector(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    public House constructHouse() {
        houseBuilder.buiildBiase();
        houseBuilder.buiildWall();
        houseBuilder.roofed();
        return houseBuilder.buildHouse();
    }

}
