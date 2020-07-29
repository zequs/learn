package com.zequs.demo.interrupt.demo;

import java.util.concurrent.TimeUnit;

/**
 * 线程 interrupt、interrupted、isInterrupted 中断特性。
 * interrupt()中断此线程
 * isInterrupted：测试线程是否中断，不清除中断状态
 * interrupted：判断当前线程是否中断，会清除中断状态（重点是当前线程）
 * InterruptedException: 中断异常会清楚中断标志
 * @author zequs
 * @version : concurrent-demo, v0.1 2020 07 16 Exp $
 */
public class InterruptTest {

    /**
     * interrupt 中断
     */
    public void t1() {

        Thread t1 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                System.out.println("线程被中断");
                e.printStackTrace();
            }
            System.out.println(11);
        });
        t1.start();
        t1.interrupt();
    }

    /**
     * isInterrupted 中断 测试线程是否中断，不清除中断状态
     */
    public void t2() {
        Thread t1 = new Thread(() -> {
            int n = 0;
            for (int i = 0; i < 100000; i++) {
                n += i;
            }
            System.out.println(n);
        });
        t1.start();
        t1.interrupt();
        System.out.println("第一次调用thread.isInterrupted():" + t1.isInterrupted());
        System.out.println("第二次调用thread.isInterrupted():" + t1.isInterrupted());
    }

    /**
     * InterruptedException 会线程复位，中断标识被清楚
     */
    public void t3() {
        Thread t1 = new Thread(() -> {
            int i = 0;
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
//                    Thread.currentThread().interrupt();
                }
                System.out.println(i++);
            }
        });
        t1.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.interrupt();
    }

    public static void main(String[] args) {
        InterruptTest test = new InterruptTest();
        test.t3();
        //interrupted：当前线程。
//        Thread.currentThread().interrupt();
//        System.out.println("第一次调用thread.interrupted():" + Thread.interrupted());
//        System.out.println("第二次调用thread.interrupted():" + Thread.interrupted());
    }
}
