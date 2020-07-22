package com.zequs.demo.lock.reentrantlock.explame;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author zequs
 * @version $Id: concurrent-demo, v0.1 2019 12 17 Exp $
 */
public class CollectEnergyThreed implements Runnable {

    private Lock      lock;
    private Condition condition;

    public CollectEnergyThreed(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        lock.lock();
        try {
            System.out.println("开始蓄能");
            Random random = new Random();
            int i = random.nextInt(3000);
            System.out.println("蓄力" + i + "毫秒");
            TimeUnit.MILLISECONDS.sleep(i);
            System.out.println("蓄能成功");
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
