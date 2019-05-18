package com.zequs.learn.se.concurent;


import java.util.concurrent.*;

/**
 *Futurn简单应用
 */
public class FutureThreadPoolDemo {
    public static void main(String args[]) throws Exception{

        //1：创建Callable
        Callable callable = () -> "hello world";
        //2：创建ExecutorService
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        //3,运行线程
        Future future = executorService.submit(callable);
        //4.获取线程的返回值
        System.out.println(future.get());
    }
}
