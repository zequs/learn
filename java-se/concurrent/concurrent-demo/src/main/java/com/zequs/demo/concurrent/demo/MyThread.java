package com.zequs.demo.concurrent.demo;

import java.util.concurrent.CountDownLatch;

/**
 * @author zequs
 * @version $Id: concurrent-demo, v0.1 2019 07 24 Exp $
 */
public class MyThread implements Runnable {
    private CountDownLatch downLatch;
    private String name;

    public   MyThread(CountDownLatch downLatch,String name){
        this.downLatch = downLatch;
        this.name = name;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ":正在处理--------");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        downLatch.countDown();
        System.out.println("结束");
    }
}
