package com.zequs.demo.se.designpattern.pattern.adapter.objectadapter;

/**
 * 对象适配器
 * 被适配类Voltage220V作为成员变量
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 01 Exp $
 */
public class ObjectAdapter implements IVoltage5V {

    private Voltage220V voltage220V;

    public ObjectAdapter(Voltage220V voltage220V) {
        this.voltage220V = voltage220V;
    }

    public int output5v() {
        int voltage220v =  voltage220V.output220v();
        int voltage5v  = voltage220v/44;
        return voltage5v;
    }
}
