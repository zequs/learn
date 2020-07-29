package com.zequs.demo.synchronize.demo;

import java.util.concurrent.TimeUnit;

public class StringThread2 implements Runnable {

    private static final String LOCK_PREFIX = "XXX---";

    private String              ip;

    public StringThread2(String ip) {
        this.ip = ip;
    }

    @Override
    public void run() {
        String lock = buildLock3();
        synchronized (lock) {
            System.out.println("[" + Thread.currentThread().getName() + "]开始运行了");
            // 休眠5秒模拟脚本调用
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("[" + Thread.currentThread().getName() + "]结束运行了");
        }
    }

    private String buildLock() {
        StringBuilder sb = new StringBuilder();
        sb.append(LOCK_PREFIX);
        sb.append(ip);

        String lock = sb.toString().intern();
        System.out.println("[" +Thread.currentThread().getName() + "]构建了锁[" + lock + "]");

        return lock;
    }
    private String buildLock2() {
        StringBuilder sb = new StringBuilder();
        sb.append(LOCK_PREFIX);
        sb.append(ip);
        String lock = sb.toString().intern();
        System.out.println("[" +Thread.currentThread().getName() + "]构建了锁[" + lock + "]");
        return lock;
    }
    private String buildLock3() {
//        System.out.println("[" +Thread.currentThread().getName() + "]构建了锁[" + ip + "]");
//        System.out.println(ip);
        return ip;
    }

    public static void main(String[] args) {
        int THREAD_COUNT = 5;
        Thread[] threads = new Thread[THREAD_COUNT];
        for (int i = 0; i < THREAD_COUNT; i++) {
            threads[i] = new Thread(new StringThread2("192.168.1.1"));
        }

        for (int i = 0; i < THREAD_COUNT; i++) {
            threads[i].start();
        }

       /* for (;;)
            ;*/
    }
}