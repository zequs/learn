package com.zequs.learn.designpatterns.proxy;

import java.lang.reflect.Proxy;

public class ProxyUser {

    public static User getProxy() {
        User user = new SuperMan();
        return (User) Proxy.newProxyInstance(User.class.getClassLoader(), User.class.getInterfaces(), new MyHanddle(user));
    }
}
