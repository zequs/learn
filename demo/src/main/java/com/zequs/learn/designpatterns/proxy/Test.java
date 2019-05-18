package com.zequs.learn.designpatterns.proxy;

import java.lang.reflect.Proxy;
import java.util.*;

public class Test {
    public static void main(String args[]) {
        User user = new SuperMan();
        MyHanddle myHanddle = new MyHanddle(user);
        User u = (User) myHanddle.getProxy();
        u.sayHello();
        Map map = new LinkedHashMap();
        map.put(1,"A");
        map.put(2,"B");
    }
}
