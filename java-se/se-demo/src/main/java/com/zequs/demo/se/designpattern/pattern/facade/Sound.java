package com.zequs.demo.se.designpattern.pattern.facade;

/**
 * 音响
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 06 Exp $
 */
public class Sound {
    private final static Sound INSTANCE = new Sound();

    private Sound() {}

    public static Sound getInstance() {
        return INSTANCE;
    }

    public void up() {
        System.out.println("音响打开");
    }

    public void down() {
        System.out.println("音响关闭");
    }
}
