package com.zequs.demo.se.designpattern.pattern.mediator;

/**
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 12 Exp $
 */
public class Curtains extends Colleague {
    public Curtains(Mediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    public void SendMessage(int stateChange) {
//        super.getMediator().getMessage();
    }


}
