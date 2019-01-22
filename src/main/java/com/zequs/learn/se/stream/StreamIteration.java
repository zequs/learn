package com.zequs.learn.se.stream;

import com.zequs.util.ObjectUtil;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamIteration {
    public static void main(String args[]) {
        iterationMap();
        iterationFlatMap();
    }

    public void iterationOne() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Stream<Integer> stream2 = Stream.of(8, 7, 6, 5, 4, 3, 2, 1);
        Stream.concat(stream, stream2)  //连接2个stream，第一个不能是无限流
                .filter(n -> n > 7)
                .limit(10)       //取10个
                .skip(2)           //从第二个数据开始
                .peek(n -> System.out.println(n))
                .sorted()   //排序
                .unordered()  //流中的顺序改为无序
//        .sequential()  //并发流改为顺序流
//        .parallel()    //顺序流改为并发流
                .collect(Collectors.toList());
    }

    /**
     * map使用
     */
    public static void iterationMap() {
        String[] strs = {"java8", "is", "easy", "to", "use"};
        List<String[]> list = Arrays.stream(strs)
                .map(str -> str.split("a"))  // 映射成为Stream<String[]>
                .distinct()
                .collect(Collectors.toList());
        for (String[] a : list) {
            System.out.println(ObjectUtil.toString(a));
        }
        Function.identity();
    }

    /**
     * flatMap使用
     */
    public static void iterationFlatMap() {
        String[] strs = {"java8", "is", "easy", "to", "use"};
        List<String> list = Arrays.stream(strs)
                .map(str -> str.split("a"))  // 映射成为Stream<String[]>
//                .flatMap(Arrays::stream)      //// 扁平化为Stream<String>
                .flatMap(str -> Arrays.stream(str))      //// 扁平化为Stream<String>  跟上面效果一样，把string[]转换成string
                .distinct()
                .collect(Collectors.toList());
        System.out.println(ObjectUtil.toString(list));
    }
}
