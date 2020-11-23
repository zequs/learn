package com.zequs.demo.concurrent.demo;

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
public class Test4 {
    public static void main(String[] args) {
        LinkedBlockingQueue queue = new LinkedBlockingQueue(1);
        MyRejectedExecutionHandler handler = new MyRejectedExecutionHandler();
        ThreadFactory threadFactory = Executors.defaultThreadFactory();

        ExecutorService services = new ThreadPoolExecutor(2, 4, 5, TimeUnit.SECONDS, queue,
            handler);
        services.execute(() -> {
            System.out.println("11111111111");
        });
        System.out.println("222");
        services.shutdown();
    }

}
