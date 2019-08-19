package com.zequs.demo.se.designpattern.pattern.state;

/**
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 09 Exp $
 */
public abstract class State {

    public abstract void deductMoney();

    public abstract boolean raffle();

    public abstract void dispensePrize();
}
