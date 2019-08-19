package com.zequs.demo.se.designpattern.pattern.mediator;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 12 Exp $
 */
public class ComcreateMediator extends Mediator{

    Map<String, Colleague> colleagueMap = new HashMap<>();

    @Override
    public void registry(Colleague colleague) {
        if (colleague != null) {

        }
    }

    @Override
    public void sendMessage() {

    }

    @Override
    public void getMessage(String stateChage, String colleageName) {

    }
}
