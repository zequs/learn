package com.zequs.learn.se.designpattern.proxy;

public class MeiTuan implements Person {

    public User user;

    public MeiTuan (User user) {
        this.user = user;
    }

    @Override
    public void buyFood() {
        System.out.println("点外卖");
        user.buyFood();
        System.out.println("可以吃了");
    }
}
