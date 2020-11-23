package com.zequs.demo.lock.reentrantlock;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * 循环栅栏，对比CountDownLatch，此栅栏可以一直循环使用
 * @author zequs
 * @version : concurrent-demo, v0.1 2020 11 06 Exp $
 */
public class CyclicBarrierTest implements Runnable {

    private CyclicBarrier cyclicBarrier;
    private String        name;

    public CyclicBarrierTest(CyclicBarrier cyclicBarrier, String name) {
        this.cyclicBarrier = cyclicBarrier;
        this.name = name;
    }

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        for (int i = 0; i < 6; i++) {
            CyclicBarrierTest cyclicBarrierTest = new CyclicBarrierTest(cyclicBarrier, "A" + i);
            new Thread(cyclicBarrierTest).start();
        }
    }

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(new Random().nextInt(10));
            System.out.println(name + "到达集合点");
            cyclicBarrier.await();
            System.out.println(name + "出发");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
