package com.zequs.demo.se.designpattern.pattern.flyweight;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 06 Exp $
 */
public class FlyweightFactory {

    Map<String, Flyweight> pools = new ConcurrentHashMap<>();

    public Flyweight getFlyweight(String key) {
        if (pools.containsKey(key)) {
            return pools.get(key);
        } else {
            Flyweight flyweight = new ConcreteFlyweight(key);
            pools.put(key,flyweight);
            return flyweight;
        }
    }

    public Integer getSize() {
       return pools.size();
    }
}
