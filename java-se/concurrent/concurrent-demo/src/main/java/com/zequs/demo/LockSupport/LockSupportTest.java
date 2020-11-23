package com.zequs.demo.LockSupport;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * await的话需要锁，锁的话synchronize同步
 * LockSupport中park的话会一直堵住，只有unpark这个线程时才会往下执行下去
 * 也可以先unpark,在park的话，unpark会起效果，park不会被锁住
 * 先unpark，后park的话，只有一次有效，不管几次unpark，park的话只能通行一次
 * 
 * @author zequs
 * @version $Id: concurrent-demo, v0.1 2020 07 10 Exp $
 */
public class LockSupportTest {
    public static void main(String[] args) {
        m1();
    }

    /**
     * LockSupport简单实用
     */
    public static void m1() {
        Thread t = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (i == 5) {
                    LockSupport.park();
                }
                System.out.println(i);
            }
        });
        t.start();
        try {
            TimeUnit.SECONDS.sleep(8);
            System.out.println("8秒后");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LockSupport.unpark(t);
    }

    /**
     * LockSupport unpack()可以之前pack实用，但只有有效一次
     * 不管调用几次只有一次又有效
     * 线程必须先start，后再unpack
     */
    private static void m2() {
        Thread t = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (i == 5) {
                    LockSupport.park();
                }
                if (i == 8) {
                    //会一直堵住，不能提前2次获取令牌
                    LockSupport.park();
                }
                System.out.println(i);
            }
        });

        t.start();
        //线程必须先启动
        LockSupport.unpark(t);
        LockSupport.unpark(t);
        System.out.println("调用unpack成功");
    }

}
