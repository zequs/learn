package com.zequs.demo.se.designpattern.pattern.facade;

/**
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 06 Exp $
 */
public class TVPlayer {
    private final static TVPlayer INSTANCE = new TVPlayer();

    private TVPlayer() {}

    public static TVPlayer getInstance() {
        return INSTANCE;
    }

    public void on() {
        System.out.println("打开TV机");
    }

    public void off() {
        System.out.println("关闭TV机");
    }
    public void play() {
        System.out.println("TV机开始工作");
    }

    public void pause() {
        System.out.println("暂停");
    }
}
