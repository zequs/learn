package com.zequs.demo.lambdademo.stream;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.zequs.demo.lambdademo.model.User;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author zequs
 * @version $Id: concurrent-demo, v0.1 2020 07 10 Exp $
 */
public class StreamTest {
    List<User> list = Lists.newArrayList();

    public StreamTest() {
        list.add(new User("张三", 18));
        list.add(new User("李四", 21));
        list.add(new User("王五", 16));
        list.add(new User("赵六", 18));
        list.add(new User("张三", 19));
    }

    /**"
     * allMatch 集合元素全部匹配返回true 否则返回false
     * 接收:一个参数
     * 返回：boolean
     *
     */
    public void  allMatchTest() {
        boolean result = list.stream().allMatch(user -> user.getAge() == 18);
        System.out.println(result);
    }
    public void  allMatchTest2() {
        boolean result = list.stream().allMatch(user -> !Strings.isNullOrEmpty(user.getName()));
        //返回true
        System.out.println(result);
    }

    /**
     * allMatch:有一个匹配就返回true
     * 接收:一个参数
     * 返回：boolean
     */
    public void  anyMatchTest() {
        boolean result = list.stream().anyMatch(user -> user.getAge() == 18);
        System.out.println(result);
    }

    /**
     * concat：两个流进行合并
     * Stream静态方法
     */
    public void  concatTest() {
        Stream<Integer> streamA = Stream.of(1, 2, 3);
        Stream<String> streamB = Stream.of("zhangsan", "lisi", "wangwu");
        Stream<? extends Serializable> concat = Stream.concat(streamA, streamB);
        concat.forEach(s -> {
            System.out.println(s);
        });
    }

    /**
     * count:返回流中元素数
     */
    public void countTest() {
        long count = list.stream().count();
        System.out.println(count);
    }


    /**
     * distinct：去重，根据元素的equals和hashCode判断是否相同
     */
    public void distinctTest() {
        Stream<String> disStream = Stream.of("zhangsan", "lisi", "wangwu", "zhangsan");
        long count = disStream.distinct().count();
        System.out.println(count);
        Stream<User> distinct = list.stream().distinct();
        distinct.forEach(user -> System.out.println(user));
    }

    public static void main(String[] args) {
        StreamTest test = new StreamTest();
        test.distinctTest();
    }


    /**
     * filter
     * 接收：一个参数
     * 返回：boolean类型
     */
    public void filterTest() {
        List<User> collect = list.stream().filter(user -> user.getAge() == 18).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(collect)) {
            collect.stream().forEach(user -> System.out.println(user.toString()));
        }
    }

    /**
     * forEach
     * 接收：一个参数
     * 返回：void
     */
    public void forEachTest() {
        list.stream().forEach(user -> System.out.println(user.toString()));
    }
}
