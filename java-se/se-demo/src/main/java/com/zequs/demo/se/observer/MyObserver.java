package com.zequs.demo.se.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 16 Exp $
 */
public class MyObserver implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("观察者");
    }
}
