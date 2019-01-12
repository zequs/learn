package com.zequs.learn.se.concurent;

import java.util.concurrent.Semaphore;

/**
 * 把它比作是控制流量的红绿灯，比如XX马路要限制流量，只允许同时有一百辆车在这条路上行使，其他的都必须在路口等待
 *
 * Semaphore信号量,semaphore.acquire()，当还有可用许可证时候，不堵塞，没有获取到许可时堵塞。
 * semaphore.release()释放许可证。
 * 应用场景： Semaphore可以用于做流量控制，比如数据库的连接数。
 *
 */
public class SemaphoreTest implements Runnable{
    int num = 2;
    Semaphore semaphore = new Semaphore(num);
    @Override
    public void run() {
        try {
            long startTime = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName() +"-----准备---------");
            semaphore.acquire();
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() +"-----dowork--------");
            semaphore.release();
            long endTime = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName() +",耗费时间：" + (endTime - startTime));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        SemaphoreTest semaphoreTest = new SemaphoreTest();
        Thread t1 = new Thread(semaphoreTest,"线程A");
        Thread t2 = new Thread(semaphoreTest,"线程B");
        Thread t3 = new Thread(semaphoreTest,"线程C");
        t1.start();
        t2.start();
        t3.start();
    }
}
