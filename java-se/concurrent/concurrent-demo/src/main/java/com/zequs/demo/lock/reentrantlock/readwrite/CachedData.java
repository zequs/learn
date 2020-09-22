package com.zequs.demo.lock.reentrantlock.readwrite;

import java.util.concurrent.locks.ReentrantReadWriteLock;

class CachedData {
    final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    Object                       data;
    volatile boolean             cacheValid;
    ReentrantReadWriteLock.WriteLock readWriteLock = new ReentrantReadWriteLock().writeLock();
    public void processCachedData() {
        rwl.readLock().lock();
        if (!cacheValid) {
            // Must release read lock before acquiring write lock
            rwl.readLock().unlock();
            rwl.writeLock().lock();
            try {
                // Recheck state because another thread might have
                // acquired write lock and changed state before we did.
                if (!cacheValid) {
                    cacheValid = true;
                }
                // Downgrade by acquiring read lock before releasing write lock
                rwl.readLock().lock();
            } finally {
                rwl.writeLock().unlock(); // Unlock write, still hold read
            }
        }
    }
}