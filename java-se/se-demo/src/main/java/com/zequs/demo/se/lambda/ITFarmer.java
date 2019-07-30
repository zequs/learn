package com.zequs.demo.se.lambda;

/**
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 07 25 Exp $
 */
public class ITFarmer implements People {
    @Override
    public void say() {
        System.out.println("are you ok");
    }

    @Override
    public void play(String name) {
        System.out.println("玩" + name);
    }
}
