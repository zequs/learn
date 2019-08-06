package com.zequs.demo.se.designpattern.pattern.proxy.statics;

/**
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 06 Exp $
 */
public class Target implements IInterface {

    @Override
    public void play() {
        System.out.println(" target play......");
    }
}
