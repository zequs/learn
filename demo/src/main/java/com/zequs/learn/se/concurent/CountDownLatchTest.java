package com.zequs.learn.se.concurent;

import java.util.concurrent.CountDownLatch;

/**
 * countDownLatch.await();直接堵塞，countDownLatch.countDown()会减少一个countDownLatch中计数器的数量即num-1，
 * 当countDownLatch中计数器为0时，运行await()之后的程序
 */

public class CountDownLatchTest implements Runnable{
    public static int num = 3;
    static CountDownLatch countDownLatch = new CountDownLatch(num);

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + "，开始工作");
            //等待，线程堵塞在这里
            countDownLatch.await();
            System.out.println(Thread.currentThread().getName() + "------------继续工作-------------");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class CountDownLatchWorker implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < num; i++) {
                System.out.println(Thread.currentThread().getName() + "，开始工作");
                //达到计数器的线程个数，后执行await()后面的程序
                countDownLatch.countDown();
                System.out.println(Thread.currentThread().getName() + "-------控制完成--------");

            }
        }
    }

    public static void main(String args[]) {
        CountDownLatchTest test = new CountDownLatchTest();
        CountDownLatchWorker worker = new CountDownLatchWorker();
        for (int i = 0; i < num ; i++) {
            Thread thread = new Thread(test, "工作线程" + i);
            thread.start();
        }
        Thread t = new Thread(worker, "控制线程");
        t.start();
    }
}
