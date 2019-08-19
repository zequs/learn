package com.zequs.demo.se.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 07 30 Exp $
 */
public class Test {
    public static void main(String[] args) {

        User user = new User("a", 1);
        User user1 = new User("b", 2);
        User user2 = new User("c", 3);
        User user3 = new User("d", 4);
        List<User> list = new ArrayList<>();
        list.add(user);
        list.add(user1);
        list.add(user2);
        list.add(user3);

     /*   list.stream().sorted(Comparator.comparing(Integer.parseInt(user::getAge))).collect(Collectors.toList());
        list.stream().sorted(Comparator.comparing(Integer.parseInt(User::getName))).collect(Collectors.toList());
        list.stream().sorted((s1,s2) -> {s1.getAge()-s2.getAge()}).collect(Collectors.toList());
        list.stream().sorted(Comparator.comparing(e -> Integer.parseInt(((User)e).getName()))).collect(Collectors.toList())

                .sorted(Comparator.comparing(e -> Integer.parseInt(e.getKey())))
                .map(e -> e.getValue()).collect(Collectors.toList())*/


        /* Map<String, User> map = list.stream().collect(Collectors.toMap(User::getName, usera -> usera));
        map.forEach((key, value) -> {
            System.out.println("key: " + key + "    value: " + value.getAge());
        });

        List<User> list2 = map.entrySet().stream().sorted(Comparator.comparing(e -> e.getKey()))
                .map(e -> e.getValue()).collect(Collectors.toList());
        list2.forEach(ddddd -> System.out.println(ddddd.getName()));*/
    }

    public static String stringEquals(String a, String b) {
        if (a.equals(b)) {
            return "相等";
        } else {
            return "不相等";
        }
    }
}
