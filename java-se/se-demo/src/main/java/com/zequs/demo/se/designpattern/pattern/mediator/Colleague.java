package com.zequs.demo.se.designpattern.pattern.mediator;

/**
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 12 Exp $
 */
public abstract class Colleague {
    private Mediator mediator;
    private String name;

    public Colleague(Mediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    //向中介者发送消息
    public abstract void SendMessage(int stateChange);


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Mediator getMediator() {
        return mediator;
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }
}
