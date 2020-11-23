package com.zequs.demo.lock.reentrantlock;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author zequs
 * @version : concurrent-demo, v0.1 2020 11 05 Exp $
 */
public class MySimpleLockTest {
    private static Unsafe unsafe;
    private static Long valueOffset;
    static {
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            unsafe= (Unsafe) theUnsafe.get(null);
            valueOffset = unsafe.objectFieldOffset(MySimpleLockTest.class.getDeclaredField("state"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private volatile  int state;

    public void  lock() {
        while (true) {
            if (unsafe.compareAndSwapInt(this, valueOffset, 0,1 )) {
                return;
            }
        }
    }

    public void unLock() {
        state = 0;
    }

    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newCachedThreadPool();
        MySimpleLockTest test = new MySimpleLockTest();
        int[] n = {0};
        for (int i = 0; i < 1000; i++) {
            executorService.submit(() -> {
                test.lock();
                n[0]++;
                test.unLock();
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(30, TimeUnit.SECONDS);
        System.out.println(n[0]);
    }
}
