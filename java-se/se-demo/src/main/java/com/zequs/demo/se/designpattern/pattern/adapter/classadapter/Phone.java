package com.zequs.demo.se.designpattern.pattern.adapter.classadapter;

/**
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 01 Exp $
 */
public class Phone {

    public void charging(IVoltage5V iVoltage5V) {
        if (iVoltage5V.output5v() == 5) {
            System.out.println("电压为5v，可以正常充电");
        } else {
            System.out.println("电压不为5v，无法正常充电");
        }
    }
}
