package com.zequs.demo.se.designpattern.pattern.memento;

/**
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 12 Exp $
 */
public class Originator {
    private String state;

    public Originator() {

    }

    public Memento saveStateMemento() {
        return new Memento(state);
    }

    public void getStateFromMemento(Memento memento) {
        state = memento.getState();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}


