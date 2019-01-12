package com.zequs.learn.se;

import com.google.common.collect.Sets;

import java.util.Set;

public class NullDemo {
    public static void main(String args[]) {
        Set<Object> set = Sets.newHashSet();
        set.add(null);
    }
}
