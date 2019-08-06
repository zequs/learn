package com.zequs.demo.se.designpattern.pattern.prototype.clone;

/**
 * 原型模式，使用clone方法，克隆基本类型和String，没有引用类型
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 01 Exp $
 */
public class ShallowCloneTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Sheep sheep = new Sheep(1,"多莉", "白", 4);
        Sheep sheep1 = (Sheep) sheep.clone();
        Sheep sheep2 = (Sheep) sheep.clone();
        Sheep sheep3 = (Sheep) sheep.clone();
        Sheep sheep4 = (Sheep) sheep.clone();
        Sheep sheep5 = (Sheep) sheep.clone();
        Sheep sheep6 = (Sheep) sheep.clone();
        sheep1.setAge(2);
        sheep3.setFoot(3);
        System.out.println(sheep);
        System.out.println(sheep1);
        System.out.println(sheep2);
        System.out.println(sheep3);
        System.out.println(sheep4);
        System.out.println(sheep5);
        System.out.println(sheep6);
    }
}
