package com.zequs.learn.se.concurent;


import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.*;

/**
 *Futurn简单应用
 */
public class FutureSimpleDemo {
    public static void main(String args[]) throws Exception{

        //1：创建一个Callable
        Callable callable = () -> "hello world";
        //2：创建FutureTask
        FutureTask task = new FutureTask(callable);
        //3：启动一个线程
        //这一步调用的是Thread(Runnable target)构造器，
        // FutureTask实现了Ruanable接口，FutureTas.
        // run()中调用了自己成员变量Callable的call()方法。
        new Thread(task).start();
        //4.获取线程的返回值
        System.out.println(task.get());
    }
}
