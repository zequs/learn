package com.zequs.learn.se.stream;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 创建流的方式
 */
public class StreamCreate {
    public static void main(String args[]) throws Exception{
        create();
    }

    public static void create() throws Exception{
        String contents = "zhangsanlisiwangwusunliuzhaoqi";
        Stream words = Stream.of(contents.split("a"));
        show("words", words);
        Stream song = Stream.of("zhangsan", "lisi", "wangwu");
        show("song", song);
        Stream empty = Stream.empty();
        show("empty", empty);
        //设置内容为Echo的常量无限流
        Stream echos = Stream.generate(() -> "Echo");
        //设置内容为1常量无限流
        show("echos", echos);
        Stream constant = Stream.generate(() -> 1);
        //设置内容为随机数的无限流
        show("constant", constant);
        Stream random = Stream.generate(Math::random);
        show("random", random);
        //设置初始值为BigDecimal.ONE，每次加1的无限流
        Stream itergers = Stream.iterate(BigDecimal.ONE, n ->n.add(BigDecimal.ONE));
        show("itergers", itergers);
        Stream wordsAnotherway = Pattern.compile("a").splitAsStream(contents);
        show("wordsAnotherway", wordsAnotherway);
        String filePath = System.getProperty("user.dir") + "/src/main/resources/a.txt";
        System.out.println(filePath);
        Path path = Paths.get(filePath);
        System.out.println(System.getProperty("user.dir"));
        //一行数据为一条数据的文件流
        Stream lines = Files.lines(path,StandardCharsets.UTF_8);
        show("lines", lines);
    }

    public static <T> void show(String title, Stream<T> stream) {
        final int SIZE = 10;
        List<T> firstElements = stream.limit(SIZE + 1).collect(Collectors.toList());
        System.out.println(title + "：");
        System.out.print("  ");
        for (int i = 0; i < firstElements.size(); i++) {
            if (i > 0) System.out.print(",");
            if (i < SIZE) System.out.print(firstElements.get(i));
            else System.out.println("...");
        }
        System.out.println();
    }
}
