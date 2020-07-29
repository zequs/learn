package com.zequs.demo.demo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zequs
 * @version : concurrent-demo, v0.1 2020 07 22 Exp $
 */
public class SetTest {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        boolean zhagnsan = set.add("zhagnsan");
        boolean zhagnsan1 = set.add("zhagnsan");
        System.out.println(zhagnsan);
        System.out.println(zhagnsan1);

        HashMap<String, String> map = new HashMap();
        String zhangsan = map.put("zhangsan", "19");
        String zhangsan1 = map.put("zhangsan", "18");
        System.out.println(zhangsan);
        System.out.println(zhangsan1);
    }
}
