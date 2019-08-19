package com.zequs.demo.se.observer;

import java.util.Observable;

/**
 * 基类Observable中的Observable是protected状态的
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 16 Exp $
 */
public class MyObservable extends Observable {
    @Override
    protected synchronized void setChanged() {
        super.setChanged();
    }
}
