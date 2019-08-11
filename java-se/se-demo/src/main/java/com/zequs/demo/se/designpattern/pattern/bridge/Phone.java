package com.zequs.demo.se.designpattern.pattern.bridge;

/**
 * 抽象类
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 02 Exp $
 */
public abstract class Phone {
    private Brand brand;

    public Phone(Brand brand) {
        this.brand = brand;
    }
    public void  open() {
        brand.open();
    }

    public void close() {
        brand.close();
    }

    public void call() {
        brand.call();
    }
}
