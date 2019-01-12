package com.zequs.learn.collection;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.AbstractList;
import java.util.List;
import java.util.Map;

public class demo {
    public static void main(String args[]) {
        Map map = Maps.newHashMap();
//        map.getOrDefault();
        map.put("a","aa");
        map.put("b","bb");
        map.put("c","cc");
        List list = Lists.newArrayList();
        map.forEach((k,v)-> System.out.println("key=" + k + v + ""));
        new AbstractList<>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public Object get(int index) {
                return null;
            }
        }
    }
}
