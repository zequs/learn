package com.zequs.demo.se.concurrent.demo;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author zequs
 * @version : se-demo, v0.1 2020 11 03 Exp $
 */
public class UnSafeTest {
    private static Unsafe unsafe;
    private static long valueOffset;

    public  UnSafeTest() {
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            unsafe = (Unsafe) theUnsafe.get(null);
            valueOffset = unsafe.objectFieldOffset((UnSafeTest.class.getDeclaredField("state")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private volatile int state;

    public static void main(String[] args) throws Exception {
        UnSafeTest test = new UnSafeTest();
        int[] i = {0};
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int j = 0; j < 1000; j++) {
            executorService.submit(() -> {
                test.lock();
                i[0]++;
                test.unLock();
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(30, TimeUnit.SECONDS);
        System.out.println(i[0]);
    }

    public boolean lock() {
        for (; ; ) {
            if (unsafe.compareAndSwapInt(this, valueOffset, 0, 1)) {
                return true;
            }
        }
    }

    public void unLock() {
        state = 0;
    }
}
