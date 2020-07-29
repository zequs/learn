package com.zequs.demo.lock.reentrantlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zequs
 * @version $Id: concurrent-demo, v0.1 2019 12 17 Exp $
 */
public class SumDeom implements Runnable {


    private static int i = 0;
    private Lock lock;

    public SumDeom(Lock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        for (int j = 0; j < 100000; j++) {
            lock.lock();
            i++;
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Thread t1 = new Thread(new SumDeom(lock));
        t1.start();
        Thread t2 = new Thread(new SumDeom(lock));
        t2.start();
        Thread t3 = new Thread(new SumDeom(lock));
        t3.start();
        Thread t4 = new Thread(new SumDeom(lock));
        t4.start();
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(i);
    }
}
