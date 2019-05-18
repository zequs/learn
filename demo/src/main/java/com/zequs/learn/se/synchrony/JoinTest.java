package com.zequs.learn.se.synchrony;

public class JoinTest implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
            System.out.println(Thread.currentThread().getName() + ": 第" + (i+1) + "次运行");
        }
    }
    public static void main(String args[]) throws Exception{
        JoinTest j = new JoinTest();
        Thread t1 = new Thread(j, "线程A");
        Thread t2 = new Thread(j, "线程B");
        t1.start();
        //让t1先执行完
//        t1.join();  //1 join的是当前线程跟调用线程，当前是main线程，调用线程是t1
        t2.join();  //2,t2线程还没start，就调用join,没啥用
        t2.start();
//        t2.join();  //3 这边是main线程礼让其他线程，t1与t2还是会竞争
        System.out.println("-----main线程-------");
    }
}
