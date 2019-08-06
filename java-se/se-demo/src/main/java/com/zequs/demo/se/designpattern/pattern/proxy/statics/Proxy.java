package com.zequs.demo.se.designpattern.pattern.proxy.statics;

/**
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 06 Exp $
 */
public class Proxy implements IInterface{
    public Target target;

    public Proxy(Target target) {
        this.target = target;
    }

    @Override
    public void  play() {
        System.out.println("调用目标方法前处理.........");
        target.play();
        System.out.println("调用目标方法后处理.........");
    }
}

