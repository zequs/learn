package com.zequs.demo.lock.reentrantlock.explame;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author zequs
 * @version $Id: concurrent-demo, v0.1 2019 12 17 Exp $
 */
public class Attack implements Runnable {
    private Lock      lock;
    private Condition condition;

    public Attack(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }
    @Override
    public void run() {
        lock.lock();
        try {
            condition.await();
            System.out.println("发射");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
