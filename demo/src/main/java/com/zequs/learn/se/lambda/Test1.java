package com.zequs.learn.se.lambda;

import com.alibaba.dubbo.rpc.Invoker;

import java.util.Arrays;

public class Test1 {
    public static void main(String args[]) {

        String[] arr = { "program", "creek", "is", "a", "java", "site" };
        Arrays.sort(arr, (String m, String n) -> {
            if (m.length() > n.length())
                return -1;
            else
                return 0;
        });

    }
}
