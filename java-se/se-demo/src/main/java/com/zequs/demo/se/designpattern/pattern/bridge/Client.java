package com.zequs.demo.se.designpattern.pattern.bridge;

/**
 * 桥接模式：把抽象与实现分开
 *
 * 抽象类（Abstraction）：Phone
 * 实现类(Implementor)：Brand(实现类基类)
 * 桥梁(Bridge)：FoldePhone
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 02 Exp $
 */
public class Client {
    public static void main(String[] args) {
        Phone phone = new FoldePhone(new XiaoMiBrand());
        phone.call();
        phone.open();
        phone.close();
    }
}
