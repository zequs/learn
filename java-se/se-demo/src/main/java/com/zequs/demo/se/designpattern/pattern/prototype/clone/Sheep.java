package com.zequs.demo.se.designpattern.pattern.prototype.clone;

import java.io.Serializable;

/**
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 01 Exp $
 */
public class Sheep implements Cloneable, Serializable {
    private int age;
    private String name;
    private String color;
    private Integer foot;

    public Sheep() {}
    public Sheep(int age, String name, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }
    public Sheep(int age, String name, String color, Integer foot) {
        this.name = name;
        this.age = age;
        this.color = color;
        this.foot = foot;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getFoot() {
        return foot;
    }

    public void setFoot(Integer foot) {
        this.foot = foot;
    }

    @Override
    public String toString() {
        return "Sheep [name:]" + name + ",age:" + age + ",color:" + color + ",foot:" + foot;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Sheep sheep = null;
        sheep = (Sheep) super.clone();
        return sheep;
    }
}
