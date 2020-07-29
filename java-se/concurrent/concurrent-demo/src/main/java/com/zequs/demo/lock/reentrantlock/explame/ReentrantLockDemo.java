package com.zequs.demo.lock.reentrantlock.explame;

import com.zequs.demo.lock.reentrantlock.explame.Attack;
import com.zequs.demo.lock.reentrantlock.explame.CollectEnergyThreed;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Condition.await()会是否锁，Condition.single()不会释放锁
 * @author zequs
 * @version $Id: concurrent-demo, v0.1 2019 12 17 Exp $
 */
public class ReentrantLockDemo {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        new Thread(new Attack(lock,condition)).start();
        new Thread(new CollectEnergyThreed(lock, condition)).start();
    }
}
