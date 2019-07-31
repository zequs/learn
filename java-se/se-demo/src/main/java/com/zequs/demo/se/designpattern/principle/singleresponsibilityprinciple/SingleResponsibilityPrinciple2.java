package com.zequs.demo.se.designpattern.principle.singleresponsibilityprinciple;

/**
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 07 30 Exp $
 */
/**
 * 设计模式-单一职责原则
 * 不符合类单一职责，但是在方法上符合单一职责
 * 当类的方法数量比较少，不复杂时，可以考虑使用此方法
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 07 30 Exp $
 */
public class SingleResponsibilityPrinciple2 {
    public static void main(String[] args) {
        Vehicle2 vehicle2 = new Vehicle2();
        vehicle2.run("摩托车");
        vehicle2.run("汽车");
        //不符合逻辑
        vehicle2.runWater("轮船");
    }
}


class Vehicle2 {
    public void  run (String vehicle) {
        System.out.println(vehicle + " 在公里上运行.......");
    }
    public void  runWater (String vehicle) {
        System.out.println(vehicle + " 在水里运行.......");
    }
}