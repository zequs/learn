package com.zequs.demo.synchronize.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author zequs
 * @version : concurrent-demo, v0.1 2020 07 20 Exp $
 */
public class WaitTest {

    /**
     * wait 方法
     */
    public static void m1() {
        Queue msg = new LinkedBlockingQueue(3);
        int maxSize = 3;
        new Thread(() -> {
            while (true) {
                synchronized (msg) {
                    if (msg.size() == maxSize) {
                        try {
                            msg.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("生成者生产.....");
                        try {
                            TimeUnit.MILLISECONDS.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        msg.add(new Object());
                        msg.notify();
                    }
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                synchronized (msg) {
                    if (msg.size() == 0) {
                        try {
                            msg.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("消费者消费一个消息");
                        msg.poll();
                        try {
                            TimeUnit.MILLISECONDS.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        msg.notify();
                    }
                }
            }
        }).start();
    }
    public static void main(String[] args) {
        m1();
    }
}
