package com.zequs.demo.synchronize.demo;

import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.TimeUnit;

/**
 * Synchronized MarkWord中锁标记测试
 * 偏向锁
 * 无锁
 * 本人用idea测试的时候，jdk默认没有开启偏向锁，已经默认偏向4秒也没有开启
 * hashCode对锁的影响
 * @author zequs
 * @version : concurrent-demo, v0.1 2020 07 17 Exp $
 */
public class SynchronizedTest {
    static Object object = new Object();

    /**
     * markword:锁位未001，既无偏向锁
     */
    public void m1() {
        Object object = new Object();
        System.out.println(ClassLayout.parseInstance(object).toPrintable());
    }

    /**
     * -XX:+UseBiasedLocking  开启偏向锁
     * -XX:BiasedLockingStartupDelay=1  延迟1秒开启
     *
     *  配置参数的话，
     */
    public void m2() {
        System.out.println(ClassLayout.parseInstance(object).toPrintable());
        System.out.println("=============================================");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Object object = new Object();
        System.out.println(ClassLayout.parseInstance(object).toPrintable());
    }
    /**
     * -XX:+UseBiasedLocking  开启偏向锁
     * -XX:BiasedLockingStartupDelay=1  延迟1秒开启
     * hashCode 对锁标记的影响
     *  配置参数的话，
     */
    public void m3() {
        //101
        System.out.println(ClassLayout.parseInstance(object).toPrintable());
        System.out.println("=============================================");
        synchronized (object) {
            //101
            System.out.println(ClassLayout.parseInstance(object).toPrintable());
            object.hashCode();
            //偏向锁无法存储hashCode
            //010 重量级锁
            System.out.println("=============================================");
            System.out.println(ClassLayout.parseInstance(object).toPrintable());
        }
    }

    public void m4() {
        System.out.println(ClassLayout.parseInstance(object).toPrintable());
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (object) {
            System.out.println(ClassLayout.parseInstance(object).toPrintable());
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("=====================================================================");
            System.out.println(ClassLayout.parseInstance(object).toPrintable());
        }
        System.out.println("=====================================================================");
        System.out.println(ClassLayout.parseInstance(object).toPrintable());
    }

    public static void main(String[] args) {
        SynchronizedTest test = new SynchronizedTest();

        test.m3();
    }
}
