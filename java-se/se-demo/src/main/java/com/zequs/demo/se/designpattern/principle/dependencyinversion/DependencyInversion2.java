package com.zequs.demo.se.designpattern.principle.dependencyinversion;

/**
 * 设计模式-接口倒转原则
 *
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 07 30 Exp $
 */
public class DependencyInversion2 {
    public static void main(String[] args) {
        Person2 person2 = new Person2();
        person2.receive(new Wachat());
        person2.receive(new Email2());
    }
}

interface IReceiver {
    public String getInfo();
}

class Person2 {
    public void receive(IReceiver iReceiver) {
        System.out.println(iReceiver.getInfo());
    }
}

class Email2 implements IReceiver {

    @Override
    public String getInfo() {
        return "电子邮件信息： hello world";
    }
}

class Wachat implements IReceiver {

    @Override
    public String getInfo() {
        return "微信信息： hello world";
    }
}