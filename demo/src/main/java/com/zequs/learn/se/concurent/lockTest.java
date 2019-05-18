package com.zequs.learn.se.concurent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class lockTest {
    Lock lock = new ReentrantLock();
    public void lock(String name) {
        // 获取锁
        lock.lock();
        try {
            System.out.println(name + " get the concurent");
            // 访问此锁保护的资源
        } finally {
            // 释放锁
            lock.unlock();
            System.out.println(name + " release the concurent");
        }
    }

    public static void main(String args[]) {
        lockTest lt = new lockTest();
        new Thread(() -> lt.lock("A")).start();
        new Thread(() -> lt.lock("B")).start();
    }
}
