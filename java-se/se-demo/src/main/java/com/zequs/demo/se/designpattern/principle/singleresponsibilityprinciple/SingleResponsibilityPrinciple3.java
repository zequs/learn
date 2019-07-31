package com.zequs.demo.se.designpattern.principle.singleresponsibilityprinciple;

/**
 * 设计模式-单一职责原则
 * 符合单一职责原则
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 07 30 Exp $
 */
public class SingleResponsibilityPrinciple3 {
    public static void main(String[] args) {
        VehicleWarter vehicleWarter = new VehicleWarter();
        vehicleWarter.run("轮船");

        VehicleAir vehicleAir = new VehicleAir();
        vehicleAir.run("飞机");

        VehicleRoad vehicleRoad = new VehicleRoad();
        vehicleRoad.run("汽车");
    }
}


class VehicleWarter {
    public void run(String vehicle) {
        System.out.println(vehicle + " 在公里上运行.......");
    }
}
class VehicleAir{
    public void run(String vehicle) {
        System.out.println(vehicle + " 在天空上运行.......");
    }
}
class VehicleRoad{
    public void run(String vehicle) {
        System.out.println(vehicle + " 在公路上运行.......");
    }
}