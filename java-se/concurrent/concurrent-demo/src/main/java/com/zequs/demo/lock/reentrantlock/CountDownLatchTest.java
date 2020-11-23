package com.zequs.demo.lock.reentrantlock;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 栅栏只有一次有效，创建栅栏的时候会有一个数量设置，当这个数量的线程到达栅栏时，线程才会被放行。然后栅栏失效了
 * @author zequs
 * @version : concurrent-demo, v0.1 2020 11 06 Exp $
 */
public class CountDownLatchTest implements Runnable {
    private CountDownLatch countDownLatch;
    private String         name;

    public CountDownLatchTest(CountDownLatch countDownLatch, String name) {
        this.name = name;
        this.countDownLatch = countDownLatch;
    }

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        CountDownLatchTest t1 = new CountDownLatchTest(countDownLatch, "A");
        CountDownLatchTest t2 = new CountDownLatchTest(countDownLatch, "B");
        CountDownLatchTest t3 = new CountDownLatchTest(countDownLatch, "C");
        new Thread(t1).start();
        new Thread(t2).start();
        new Thread(t3).start();

        new Thread(() -> {
            try {
                System.out.println("老师已到教室");
                countDownLatch.await();
                System.out.println("老师：全部集合出发..");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(new Random().nextInt(2));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + "同学已到教室");
        countDownLatch.countDown();
    }

}
