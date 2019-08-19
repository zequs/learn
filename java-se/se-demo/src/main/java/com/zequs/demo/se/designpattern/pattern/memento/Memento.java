package com.zequs.demo.se.designpattern.pattern.memento;

/**
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 12 Exp $
 */
public class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
