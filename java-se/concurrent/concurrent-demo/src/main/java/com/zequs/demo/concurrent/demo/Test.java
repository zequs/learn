package com.zequs.demo.concurrent.demo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author zequs
 * @version $Id: concurrent-demo, v0.1 2019 07 24 Exp $
 */
public class Test {
    public static void main(String[] args) {
        LinkedBlockingQueue queue = new LinkedBlockingQueue(1);
        MyRejectedExecutionHandler handler = new MyRejectedExecutionHandler();
        ThreadFactory threadFactory = Executors.defaultThreadFactory();

        ExecutorService services = new ThreadPoolExecutor(2,4,5, TimeUnit.SECONDS, queue, handler);

        CountDownLatch countDownLatch = new CountDownLatch(5);
        MyThread myThreadA = new MyThread(countDownLatch,"MyA");
        MyThread myThreadB = new MyThread(countDownLatch,"MyB");
        MyThread myThreadC = new MyThread(countDownLatch,"MyC");
        MyThread myThreadD = new MyThread(countDownLatch,"MyD");
        MyThread myThreadE = new MyThread(countDownLatch,"MyE");
        SubThread subThread = new SubThread(countDownLatch,"sub");


        services.execute(myThreadA);
        services.execute(myThreadB);
        services.execute(myThreadC);
        services.execute(myThreadD);
        services.execute(myThreadE);

        new Thread(subThread).start();
        System.out.println(11);
//        services.shutdown();
    }

}
