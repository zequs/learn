package com.zequs.demo.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 软引用，当内存不够用的时候，会回收
 * @author zequs
 * @version : concurrent-demo, v0.1 2020 11 09 Exp $
 */
public class SoftReferenceTest {

    /**
     * 强引用
     * @throws Exception
     */
    public static void t1() throws Exception {
        M m = new M();
        System.gc();
        System.in.read();
    }

    /**
     * 没引用，调用System.gc()时直接被GC了
     * @throws Exception
     */
    public static void t2() throws Exception {
        M m = new M();
        m = null;
        System.gc();
        System.in.read();
    }

    /**
     * -Xms20M -Xmx20M
     * 软引用，当内存不够用的时候会被好回收
     * @throws Exception
     */
    public static void t3() throws Exception {
        //10M
        SoftReference<byte[]> reference = new SoftReference<>(new byte[1024 * 1024 * 10]);
        System.out.println(reference.get());
        System.gc();
        TimeUnit.SECONDS.sleep(1);
        System.out.println(reference.get());
        byte[] b = new byte[1024 * 1024 * 12];
        System.out.println(reference.get());
    }

    /**
     * 弱引用，只要垃圾回收，直接回收。
     * ThreadLocal 使用到了弱引用
     * @throws Exception
     */
    public static void t4() throws Exception {
        //10M
        WeakReference<M> reference = new WeakReference<>(new M());
        System.out.println(reference.get());
        System.gc();
        System.out.println(reference.get());
    }

    /**
     * 虚引用 回收的时候会放在ReferenceQueue队列中
     * @throws Exception
     */
    public static void t5() throws Exception {
        List<byte[]> list = new ArrayList<>();
        ReferenceQueue<M> queue = new ReferenceQueue();
        PhantomReference<M> reference = new PhantomReference<>(new M(), queue);

        new Thread(() -> {
            int i = 0;
            while (true) {
                list.add(new byte[1024 * 1024]);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i++ + ":" + reference.get());
            }
        }).start();

        new Thread(() -> {
            while (true) {
                Reference<? extends M> poll = queue.poll();
                if (poll != null) {
                    System.out.println("-----------虚引用已被JVM回收了------------");
                }
            }
        }).start();
    }

    public static void main(String[] args) throws Exception {
        t5();
    }
}
