package com.zequs.demo.lock.reentrantlock;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 信号量，
 * 拿到令牌的线程可以执行，不然等在acquire()方法这么，线程拿到令牌之后执行，release()释放令牌，其他线程可以争抢
 * @author zequs
 * @version : concurrent-demo, v0.1 2020 11 07 Exp $
 */
public class SemaphoreTest implements Runnable {

    Semaphore semaphore;

    String    name;

    public SemaphoreTest(Semaphore semaphore, String name) {
        this.semaphore = semaphore;
        this.name = name;
    }

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);
        for (int i = 0; i < 10; i++) {
            SemaphoreTest test = new SemaphoreTest(semaphore, "A" + i);
            new Thread(test).start();
        }
    }

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(new Random().nextInt(8));
            semaphore.acquire();
            System.out.println(name + "：进入");
            semaphore.release();
            System.out.println(name + "：出去");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
