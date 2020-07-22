package com.zequs.demo.se.lambda;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 07 25 Exp $
 */
public class Test {
    public static void main(String[] args) {
        System.out.println();
        List<Integer> list = new ArrayList<>();
        list.add(100);
        list.add(30);
        list.add(88);
        list.add(35);
//        Set<String> collect = list.stream().collect(Collectors.toCollection(TreeSet::new));
//        String result = list.stream().collect(Collectors.collectingAndThen(Collectors.averagingInt(t -> t), item -> "average  is " + item));
//        String result = list.stream().collect(Collectors.collectingAndThen(Collectors.averagingInt(t -> t), item -> "average  is " + item));
//        list.stream().collect(Collectors.maxBy(Integer::compare)).ifPresent(System.out::println);
        IntSummaryStatistics result = list.stream().collect(Collectors.summarizingInt(t -> t));
//        Integer result = list.stream().collect(Collectors.reducing(0, t -> t, Integer::sum));
        System.out.println(result);
    }

}
