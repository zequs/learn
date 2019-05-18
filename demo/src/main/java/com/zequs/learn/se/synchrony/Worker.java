package com.zequs.learn.se.synchrony;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

public class Worker implements Runnable {
    @Override
    public void run() {
//        mothodA();//同一个对象才同步
//        mothodB();//不同对象也同步
        mothodC();//同一个对象同步
//        mothodD();//不同对象也同步
    }


    public static void mothod() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + ":第" + i + "次运行");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public synchronized void mothodA() {
        mothod();
    }
    public static synchronized void mothodB() {
        mothod();
    }
    public void mothodC() {
        synchronized (this) {
            mothod();
        }
    }
    public void mothodD() {
        synchronized (Worker.class) {
            mothod();
        }
    }

    public static void main(String args[]) throws  Exception{
        Worker worker = new Worker();
        Worker worker2 = new Worker();
        Thread t1 = new Thread(worker, "线程1");
        Thread t2 = new Thread(worker2, "线程2");
        t1.start();
        t2.start();
    }
}
