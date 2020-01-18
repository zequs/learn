package com.zequs.demo.concurrent.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo implements Runnable {

    private Lock lock;

    public LockDemo(Lock lock) {
        this.lock = lock;
    }


    static int i = 0;


    @Override
    public void run() {
        lock.lock();
        for (int j = 0; j < 100; j++) {
            i++;
        }
        lock.unlock();
    }

    public static void main(String args[]) {
        Lock lock = new ReentrantLock();

        Thread thread1 = new Thread(new LockDemo(lock));
        Thread thread2 = new Thread(new LockDemo(lock));
        Thread thread3 = new Thread(new LockDemo(lock));
        thread1.start();
        thread2.start();
        thread3.start();
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(i);
    }
}
