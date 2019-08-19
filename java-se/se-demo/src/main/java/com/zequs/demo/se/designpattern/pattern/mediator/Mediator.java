package com.zequs.demo.se.designpattern.pattern.mediator;

/**
 * 中介者抽象类
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 12 Exp $
 */
public abstract class Mediator {

    public abstract void registry(Colleague colleague);

    public abstract void sendMessage();

    public abstract void getMessage(String stateChage, String colleageName);
}
