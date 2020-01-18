package com.zequs.demo.se.lambda.test;

import com.zequs.demo.se.lambda.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {
    public static void main(String[] args) {
        List<Apple> list = new ArrayList();
        list.add(new Apple("red", 1.2f));
        list.add(new Apple("green", 1.5f));
        list.add(new Apple("black", 1.3f));
//        filterTest(list);
//        mapTest(list);
//        sortedTest(list);
        forEachTest();
    }

    /**
     * Stream.peek()此方法 Consumer 格式是 T-> viod
     * 对结果不会有变化，但可以修改里面的内容，返回值为void
     *
     * @param list
     */
    public static void peekTest(List<Apple> list) {
        List<Apple> appleList = list.stream().peek(apple -> {
            apple.setWeight(1.1f);
        }).collect(Collectors.toList());

        appleList.stream().forEach(apple -> {
            System.out.println(apple.toString());
        });
    }

    /**
     * filter()方法接收参数Predicate 格式 T -> boolean
     * 接收一个元素，返回boolean类型，流会刷选返回值为ture的元素
     *
     * @param list
     */
    public static void filterTest(List<Apple> list) {
        List<Apple> appleList = list.stream().filter(apple -> apple.getColor().equals("red")).collect(Collectors.toList());

        appleList.stream().forEach(apple -> {
            System.out.println(apple.toString());
        });
    }


    /**
     * 接收参数Function<T,R>参数，格式 T -> R
     *
     * @param list
     */
    public static void mapTest(List<Apple> list) {
        List<String> appleList = list.stream().map(apple -> apple.getColor()).
                collect(Collectors.toList());

        appleList.stream().forEach(apple -> {
            System.out.println(apple);
        });
    }

    /**
     * sorted两个重载方法，
     * 一个是不接收任何参数，
     * 另一个是接收 Comparator参数，格式 （T1,T2） -> int
     *
     * @param list
     */
    public static void sortedTest(List<Apple> list) {
        List<Apple> appleList = list.stream().sorted((a1, a2) -> {
            return a1.getColor().compareTo(a2.getColor());
        }).
                collect(Collectors.toList());
        List<Apple> appleList2 = list.stream().sorted(Comparator.comparing(Apple::getColor)).
                collect(Collectors.toList());
        List<String> appleList3 = list.stream().map(Apple::getColor)
//                .sorted().  //这个也可以，跟下面这个一样的功能，使用的是无参方法
                .sorted(String::compareTo).  ////跟上面这个一样的功能
                collect(Collectors.toList());
        appleList.stream().forEach(apple -> {
            System.out.println(apple);
        });
        System.out.println("------------------------------------------");
        appleList2.stream().forEach(apple -> {
            System.out.println(apple);
        });
        appleList3.stream().forEach(apple -> {
            System.out.println(apple);
        });
    }

    /**
     * forEach与forEachOrdered的区别就是在并发处理时forEachOrdered还是会按照原来顺序进行处理。forEach随机顺序处理
     *
     */
    public static void forEachTest() {
        List<String> list = new ArrayList<>();
        list.add("b");
        list.add("a");
        list.add("c");
        list.stream().forEach(s -> {
            System.out.println(s);
        });
        System.out.println("------------------------");
        list.stream().forEachOrdered(s -> {
            System.out.println(s);
        });
        System.out.println("************************");
        list.parallelStream().forEach(s -> {
            System.out.println(s);
        });
        System.out.println("------------------------");
        list.parallelStream().forEachOrdered(s -> {
            System.out.println(s);
        });
    }

    /**
     * toArray()接收参数 IntFunction 格式 int -> R
     */
    public static void toArrayTest() {
        List<String> strs = Arrays.asList("a", "b", "c");
        //
        String[] dd = strs.stream().toArray(str -> new String[strs.size()]);
        // new String[](i)的缩写 i具体数字
        String[] dd1 = strs.stream().toArray(String[]::new);
    }
}
