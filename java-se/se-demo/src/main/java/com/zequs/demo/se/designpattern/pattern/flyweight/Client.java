package com.zequs.demo.se.designpattern.pattern.flyweight;

/**
 * 享元模式：池化技术。线程池，缓冲区，连接池等
 * 池子：FlyweightFactory
 * 外部状态（共享部分）：ConcreteFlyweight
 * 内部状态（不共享部分）：UnShareConcreteFlyweight
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
