package com.zequs.demo.se.concurrent.readwritelock;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author zequs
 * @version : se-demo, v0.1 2020 11 02 Exp $
 */
public class readWriteLockDemo {
    public static void main(String[] args) {

    }


    /**
     * 读写锁
     */
    public void test1() {
        Queue<Object> queue = new LinkedBlockingQueue(3);
        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
        ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();
        readLock.lock();
        writeLock.lock();
        Thread readThread = new Thread(() ->{
            if (queue.size() != 0) {
                readLock.lock();
                Object poll = queue.poll();
            }
        });
        for (int i = 0; i < 5; i++) {
            readLock.lock();
            Object poll = queue.poll();
        }
    }
}
