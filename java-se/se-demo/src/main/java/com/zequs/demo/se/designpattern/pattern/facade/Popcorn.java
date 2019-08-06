package com.zequs.demo.se.designpattern.pattern.facade;

/**
 * 爆米花
 *
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 06 Exp $
 */
public class Popcorn {
    private final static Popcorn INSTANCE = new Popcorn();

    private Popcorn() {
    }

    public  static Popcorn getInstance() {
        return INSTANCE;
    }
   /* putMaterial():void
    bake():void
    pop():void*/

    public void putMaterial() {
        System.out.println("爆米花开始放料");
        System.out.println("加入玉米");
        System.out.println("加入蜂蜜");
    }

    public void bake() {
        System.out.println("开始炸爆米花");
    }

    public void pop() {
        System.out.println("BOM 爆米花出锅了");
    }
}
