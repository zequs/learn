package com.zequs.demo.se.designpattern.principle.dependencyinversion;

/**
 * 依赖倒转原则 方式1
 * 错误例子
 *
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 07 30 Exp $
 */
public class DependencyInversion {
    public static void main(String[] args) {
        Person person = new Person();
        person.receive(new Email());
    }
}

class Email {
    public String getInfo() {
        return "电子邮件信息： hello world";
    }
}

//完成person接口消息的功能
//方式1:分析
//1：简单，比较容易想到
//2：如果我们获取的对象是微信，短信等等，则新增类，同时Person也要增加相应的接收方式。
//3：解决思路：引用一个抽象的接口IReceiver,表示接收者，这样person类与接口IReceiver发生依赖。
//  因为Email，wechat等等都属于接收的范围他们各自实现IReceiver接口就ok,这样我们就符合依赖倒转
class Person {
    public void receive(Email email) {
        System.out.println(email.getInfo());
    }
}