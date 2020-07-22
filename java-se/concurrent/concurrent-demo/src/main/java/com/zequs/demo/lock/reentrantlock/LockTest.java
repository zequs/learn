package com.zequs.demo.lock.reentrantlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zequs
 * @version $Id: concurrent-demo, v0.1 2020 07 10 Exp $
 */
public class LockTest implements Runnable{
    Lock lock = new ReentrantLock();
    static int num= 0;


    public static void main(String[] args) throws InterruptedException {
        LockTest lockTest = new LockTest();
        Thread t1 = new Thread(lockTest);
        Thread t2 = new Thread(lockTest);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(LockTest.num);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            lock.lock();
            num++;
            lock.unlock();
        }
    }
}
