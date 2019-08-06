package com.zequs.demo.se.designpattern.pattern.bridge;

/**
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 02 Exp $
 */
public class XiaoMiBrand implements Brand{

    @Override
    public void open() {
        System.out.println("小米手机开机");
    }

    @Override
    public void close() {
        System.out.println("小米手机关机");
    }

    @Override
    public void call() {
        System.out.println("小米手机打电话");
    }
}
