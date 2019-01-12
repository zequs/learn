package com.zequs.learn.se.designpattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class UserInvocationHandle implements InvocationHandler {
    public Object object;

    public UserInvocationHandle(Object object) {
        this.object = object;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("点外卖");
        Object obj =  method.invoke(object, args);
        System.out.println("吃饭");
        return obj;
    }
}
