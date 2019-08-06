package com.zequs.demo.se.designpattern.pattern.prototype.clone;

/**
 * 原型模式，使用clone方法，克隆基本类型和String，没有引用类型
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 01 Exp $
 */
public class DeepCloneTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Sheep sheep = new Sheep(1,"多莉", "白", 4);
        CloneSheep cloneSheep = new CloneSheep();
        cloneSheep.setSheep(sheep);
        cloneSheep.setDescribe("多莉是第一克隆羊");

        CloneSheep cloneSheep1 = (CloneSheep) cloneSheep.clone();
        CloneSheep cloneSheep2 = (CloneSheep) cloneSheep.clone();
        CloneSheep cloneSheep3 = (CloneSheep) cloneSheep.clone();
        CloneSheep cloneSheep4 = (CloneSheep) cloneSheep.clone();
        CloneSheep cloneSheep5 = (CloneSheep) cloneSheep.clone();

        cloneSheep.getSheep().setColor("红");

        System.out.println(cloneSheep);
        System.out.println(cloneSheep1);
        System.out.println(cloneSheep2);
        System.out.println(cloneSheep3);
        System.out.println(cloneSheep4);
        System.out.println(cloneSheep5);
    }
}
