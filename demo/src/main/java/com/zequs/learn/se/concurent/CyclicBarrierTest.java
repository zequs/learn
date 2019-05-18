package com.zequs.learn.se.concurent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 *  cyclicBarrier.await()直接堵塞，当等待线程满足cyclicBarrier的计数器数量后，运行后面的程序
 *  栅栏作用。
 */
public class CyclicBarrierTest implements Runnable{
    TeamThread teamThread = new TeamThread();

    CyclicBarrier cyclicBarrier = new CyclicBarrier(3, teamThread);

    public void team() {
        try {
            Thread.sleep(100);
            System.out.println(Thread.currentThread().getName() + "做好准备。已经有"+ cyclicBarrier.getNumberWaiting() + "人做好准备。");
            cyclicBarrier.await();
            System.out.println(Thread.currentThread().getName() + "组队成功，开始打怪！！！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        team();
    }

    class TeamThread implements Runnable {

        @Override
        public void run() {
            System.out.println("--------------进入副本---------------");
        }
    }

    public static void main(String args[]) {
        CyclicBarrierTest cyclicBarrierTest = new CyclicBarrierTest();
        Thread t1 = new Thread(cyclicBarrierTest, "张三");
        Thread t2 = new Thread(cyclicBarrierTest, "李四");
        Thread t3 = new Thread(cyclicBarrierTest, "王五");
        Thread t4 = new Thread(cyclicBarrierTest, "孙六");
        Thread t5 = new Thread(cyclicBarrierTest, "赵七");
        Thread t6 = new Thread(cyclicBarrierTest, "钱八");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
    }
}
