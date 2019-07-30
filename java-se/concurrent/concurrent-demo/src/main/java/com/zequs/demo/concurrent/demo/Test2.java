package com.zequs.demo.concurrent.demo;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author zequs
 * @version $Id: concurrent-demo, v0.1 2019 07 24 Exp $
 */
public class Test2 {
    public static void main(String[] args) {
        //计划生产码包个数
        int size = 8;
        //用于检测是否全部生产完成
        final ArrayList<Integer> list = new ArrayList<Integer>(size);
        //核心线程数
        int corePoolSize = 3;
        //最大线程数
        int maximumPoolSize = 6;
        //超过 corePoolSize 线程数量的线程最大空闲时间
        long keepAliveTime = 2;
        //以秒为时间单位
        TimeUnit unit = TimeUnit.SECONDS;
        //创建工作队列，用于存放提交的等待执行任务
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<Runnable>(2);
        ThreadPoolExecutor threadPoolExecutor = null;
        try {
            //创建线程池
            threadPoolExecutor = new ThreadPoolExecutor(corePoolSize,
                    maximumPoolSize,
                    keepAliveTime,
                    unit,
                    workQueue,
                    new ThreadPoolExecutor.AbortPolicy());

            //循环提交任务
            for (int i = 0; i < size; i++) {
                //提交任务的索引
                final int index = (i + 1);
                threadPoolExecutor.submit(
                        new Runnable() {
                            @Override
                            public void run() {
                                System.out.println("大家好，我是线程：" + index);
                                try {
                                    //模拟线程执行时间，10s
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                list.add(1);
                            }
                        });
                //每个任务提交后休眠500ms再提交下一个任务，用于保证提交顺序
                Thread.sleep(500);
            }

            while (true){
                if (size == list.size()){
                    System.out.println("全部任务已经完成");
                    break;
                }
                Thread.sleep(1000);
                System.out.println("还没有完成，请等待");
            }
            System.out.println("准备开始压缩");

            threadPoolExecutor.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("大家好，我是线程：" + 456);
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            threadPoolExecutor.shutdown();
        }

    }

}
