package com.zequs.demo.se.designpattern.pattern.builder;

/**
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 01 Exp $
 */
public class House {
    private String  baise;
    private String wall;
    private String roofed;

    public String getBaise() {
        return baise;
    }

    public void setBaise(String baise) {
        this.baise = baise;
    }

    public String getWall() {
        return wall;
    }

    public void setWall(String wall) {
        this.wall = wall;
    }

    public String getRoofed() {
        return roofed;
    }

    public void setRoofed(String roofed) {
        this.roofed = roofed;
    }
}
