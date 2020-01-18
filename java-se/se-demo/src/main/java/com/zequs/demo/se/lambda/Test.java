package com.zequs.demo.se.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 07 25 Exp $
 */
public class Test {
    public static void main(String[] args) {
        List<Apple> list = new ArrayList();

        list.add(new Apple("red", 1.2f));
        list.add(new Apple("green", 1.5f));
        list.add(new Apple("black", 1.3f));
        list.sort(Comparator.comparing(apple -> apple.getWeight()));
        for (Apple apple : list) {
            System.out.println(apple.getWeight());
        }

       /* System.out.println("----------");
        list.sort(Comparator.comparing(Apple::getColor).reversed().thenComparing(Apple::getWeight));

//        list.sort(Comparator.comparing(apple -> apple.getColor()).reversed());

        List<String> collect = list.stream().map(a -> a.getColor()).collect(Collectors.toList());*/

        List<Apple> appleList = list.stream().peek(apple -> {
            apple.setWeight(1.1f);
        }).collect(Collectors.toList());

        appleList.stream().forEach(apple -> {
            System.out.println(apple.toString());});
    }
}
