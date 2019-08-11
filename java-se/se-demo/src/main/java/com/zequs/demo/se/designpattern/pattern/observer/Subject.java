package com.zequs.demo.se.designpattern.pattern.observer;

/**
 * 被依赖对象，1的一方
 */
public abstract class Subject {
    public abstract void registry(Observer observer);

    public abstract void remove(Observer observer);

    public abstract void notifyObserver();
}
