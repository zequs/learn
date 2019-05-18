package com.zequs.learn.se.designpattern.proxy;

import java.lang.reflect.Proxy;

public class Demo {
    public static void main(String args[]) {
        Demo demo = new Demo();
        User user = new User();
//        demo.dynamicProxy(user);
        demo.staticProxy(user);
    }

    public void staticProxy(User user) {
        MeiTuan meiTuan  = new MeiTuan(user);
        meiTuan.buyFood();
    }

    public void dynamicProxy(User user) {
       Person person =(Person) Proxy.newProxyInstance(user.getClass().getClassLoader(),user.getClass().getInterfaces() ,new UserInvocationHandle(user));
       person.buyFood();
    }
}
