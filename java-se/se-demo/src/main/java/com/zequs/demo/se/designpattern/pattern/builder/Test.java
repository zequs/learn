package com.zequs.demo.se.designpattern.pattern.builder;

/**
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 01 Exp $
 */
public class Test {
    public static void main(String[] args) {
        //不同建造者
        HouseBuilder houseBuilder  = new CommonBuilder();
        //建造方式
        HouseDirector houseDirector = new HouseDirector(houseBuilder);
        //组装
        House house = houseDirector.constructHouse();
        System.out.println(house.getBaise());
    }
}
