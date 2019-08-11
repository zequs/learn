package com.zequs.demo.se.designpattern.pattern.adapter.objectadapter;

/**
 *
 * 接口适配模式
 * interfaceAdapter 原本是继承被适配器类的改成适配器中的成员对象了
 *
 * 被适配类：Voltage220V
 * 适配类：IVoltage5V
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 01 Exp $
 */
public class Client {
    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.charging(new ObjectAdapter(new Voltage220V()));
    }
}
