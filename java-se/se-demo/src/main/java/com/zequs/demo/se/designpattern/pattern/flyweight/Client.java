package com.zequs.demo.se.designpattern.pattern.flyweight;

/**
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 06 Exp $
 */
public class Client {
    public static void main(String[] args) {
        FlyweightFactory flyweightFactory = new FlyweightFactory();
        flyweightFactory.getFlyweight("x");
        flyweightFactory.getFlyweight("y");
        flyweightFactory.getFlyweight("z");
        flyweightFactory.getFlyweight("y");
        flyweightFactory.getFlyweight("y");
        flyweightFactory.getFlyweight("y");
        flyweightFactory.getFlyweight("x");
        flyweightFactory.getFlyweight("z");
        System.out.println(flyweightFactory.getSize());
    }
}
