package com.zequs.demo.se.designpattern.pattern.composite;

/**
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 05 Exp $
 */
public abstract class Component {

    private String name;
    private String desc;

    public Component(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public abstract void operation();

    public abstract void add(Component c);

    public abstract void remove(Component c);

    public abstract void print();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
