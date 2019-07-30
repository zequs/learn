package com.zequs.demo.se.designpattern.philosophy.singleresponsibilityprinciple;

/**
 * 设计模式-单一职责原则
 * 业务变动
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 07 30 Exp $
 */
public class SingleResponsibilityPrinciple {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.run("摩托车");
        vehicle.run("汽车");
        //不符合逻辑
        vehicle.run("轮船");
    }
}


class Vehicle {
    public void  run (String vehicle) {
        System.out.println(vehicle + " 在公里上运行.......");
    }
}
