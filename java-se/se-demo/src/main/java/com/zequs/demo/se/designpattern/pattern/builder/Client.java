package com.zequs.demo.se.designpattern.pattern.builder;

/**
 * 建造者模式
 *
 * 产品（project）：House
 * 抽象建造者（build）:HouseBuilder
 * 指挥者（Director）:HouseDirector
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 01 Exp $
 */
public class Client {
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
