package com.zequs.demo.se.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 16 Exp $
 */
public class Test {
    public static void main(String[] args) {
        Observer observer = new MyObserver();
        //
        Observable observable = new MyObservable();
        observable.addObserver(observer);
        //改变状态,才能通知
        ((MyObservable) observable).setChanged();
        observable.notifyObservers();
    }
}
