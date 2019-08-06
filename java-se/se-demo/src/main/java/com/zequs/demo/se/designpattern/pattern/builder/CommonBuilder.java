package com.zequs.demo.se.designpattern.pattern.builder;

/**
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 01 Exp $
 */
public class CommonBuilder extends HouseBuilder {
    @Override
    public void buiildBiase() {
        this.house.setBaise("打10米地基");
        System.out.println("打10米地基");

    }

    @Override
    public void buiildWall() {
        this.house.setBaise("建10cm的墙");
        System.out.println("建10cm的墙");
    }

    @Override
    public void roofed() {
        this.house.setRoofed("盖上人字屋顶");
        System.out.println("盖上人字屋顶");
    }
}
