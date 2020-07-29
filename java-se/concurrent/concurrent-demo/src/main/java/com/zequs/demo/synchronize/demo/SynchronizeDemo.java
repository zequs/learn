package com.zequs.demo.synchronize.demo;

import java.util.concurrent.TimeUnit;

/**
 * Synchronize关键字使用，锁方法，锁类，锁块，锁静态等等
 * @author zequs
 * @version $Id: concurrent-demo, v0.1 2019 10 10 Exp $
 */
public class SynchronizeDemo {
    String name;
    Object lock = new Object();

    public SynchronizeDemo() {
    }

    public SynchronizeDemo(String name) {
        this.name = name;
    }

    //锁对象，相同的SynchronizeDemo对象同步执行，不同的SynchronizeDemo对象不同步
    public synchronized void m1() throws Exception {
        Long startTime = System.currentTimeMillis();
        System.out.println("普通方法");
        TimeUnit.SECONDS.sleep(3);
        long endTime = System.currentTimeMillis();
        System.out.println("time = " + (endTime - startTime));
    }

    //锁类，不同的 SynchronizeDemo 对象依然同步执行
    public synchronized static void m2() throws Exception {
        Long startTime = System.currentTimeMillis();
        System.out.println("静态方法");
        TimeUnit.SECONDS.sleep(3);
        long endTime = System.currentTimeMillis();
        System.out.println("time = " + (endTime - startTime));
    }

    //锁对象，相同的SynchronizeDemo对象同步执行，不同的SynchronizeDemo对象不同步
    public void m3() throws Exception {
        synchronized (this) {
            Long startTime = System.currentTimeMillis();
            System.out.println("synchronized (this)块");
            TimeUnit.SECONDS.sleep(3);
            long endTime = System.currentTimeMillis();
            System.out.println("time = " + (endTime - startTime));
        }
    }

    //锁类，不同的 SynchronizeDemo 对象依然同步执行
    public void m4() throws Exception {
        synchronized (SynchronizeDemo.class) {
            Long startTime = System.currentTimeMillis();
            System.out.println("synchronized (class)块");
            TimeUnit.SECONDS.sleep(3);
            long endTime = System.currentTimeMillis();
            System.out.println("time = " + (endTime - startTime));
        }
    }

    //字符串比较特殊，字符串保存在常量池中，不管对象是否相同，name值一样就会同步处理。
    public void m5() throws Exception {
        synchronized (getLock()) {
            System.out.println("hashCOde:" + System.identityHashCode(getLock()));
            Long startTime = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName() + " : synchronized (String)块");
            TimeUnit.SECONDS.sleep(2);
            long endTime = System.currentTimeMillis();
            System.out.println("time = " + (endTime - startTime));
        }
    }
    public String getLock() {
        String lock = "zs";
        System.out.println(lock);
        return lock;
    }

    public void m7() throws Exception {
        synchronized (getLock()) {
            System.out.println("hashCOde7:" + name.hashCode());
            Long startTime = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName() + " : synchronized (String)块7");
            TimeUnit.SECONDS.sleep(3);
            long endTime = System.currentTimeMillis();
            System.out.println("time7 = " + (endTime - startTime));
        }
    }

    //锁对象，相同的SynchronizeDemo对象同步执行，不同的SynchronizeDemo对象不同步
    public void m6() throws Exception {
        synchronized (lock) {
            Long startTime = System.currentTimeMillis();
            System.out.println("synchronized (Object)块");
            TimeUnit.SECONDS.sleep(3);
            long endTime = System.currentTimeMillis();
            System.out.println("time = " + (endTime - startTime));
        }
    }

    public static void main(String[] args) throws Exception {
        Long startTime = System.currentTimeMillis();
        SynchronizeDemo demo = new SynchronizeDemo("zs");
        SynchronizeDemo demo2 = new SynchronizeDemo("zs");
        new Thread(() -> {
            try {
                demo.m5();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                demo.m7();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
       /* new Thread(() -> {
            try {
                demo2.m5();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();*/

        long endTime = System.currentTimeMillis();
        System.out.println("总花费time = " + (endTime - startTime));
    }
}
