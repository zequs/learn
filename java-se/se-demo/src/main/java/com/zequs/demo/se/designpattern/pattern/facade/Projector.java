package com.zequs.demo.se.designpattern.pattern.facade;

/**
 * 投影仪
 *
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 06 Exp $
 */
public class Projector {
    private final static Projector INSTANCE = new Projector();

    private Projector() {
    }

    public static Projector getInstance() {
        return INSTANCE;
    }

    public void on() {
        System.out.println("打开投影仪");
    }

    public void off() {
        System.out.println("关上投影仪");
    }

    public void focus() {
        System.out.println("投影仪开始聚焦");
    }
}
