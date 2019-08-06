package com.zequs.demo.se.designpattern.pattern.adapter.classadapter;

/**
 * 类适配器
 * 被适配类Voltage220V 作为基类，用于继承
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 01 Exp $
 */
public class ClassAdapter extends Voltage220V implements IVoltage5V {

    @Override
    public int output5v() {
        int voltage220v =  this.output220v();
        int voltage5v  = voltage220v/44;
        return voltage5v;
    }
}
