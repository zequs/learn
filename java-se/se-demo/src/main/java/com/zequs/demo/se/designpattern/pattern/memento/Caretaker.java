package com.zequs.demo.se.designpattern.pattern.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 12 Exp $
 */
public class Caretaker {
    List<Memento> mementos;

    public Caretaker() {
        mementos = new ArrayList<>();
    }

    public void add(Memento memento) {
        mementos.add(memento);
    }

    public Memento getMemento(int index) {
       return mementos.get(index);
    }
}
