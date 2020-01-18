package com.zequs.demo.concurrent.demo;

import java.util.concurrent.CountDownLatch;

/**
 * @author zequs
 * @version $Id: concurrent-Demo, v0.1 2019 07 24 Exp $
 */
public class SubThread implements Runnable {
    private CountDownLatch downLatch;
    private String name;

    public SubThread(CountDownLatch downLatch, String name){
        this.downLatch = downLatch;
        this.name = name;
    }
    @Override
    public void run() {
        System.out.println(name +"准备压缩--------------");
        try {
            this.downLatch.await();
            System.out.println("=====开始压缩======");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("======压缩结束=====");
    }
}
