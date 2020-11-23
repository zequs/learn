package com.zequs.demo.lock.reentrantlock;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.concurrent.Exchanger;

/**
 * 线程数据交换
 * @author zequs
 * @version : concurrent-demo, v0.1 2020 11 07 Exp $
 */
public class ExchangeTest implements Runnable {

    Exchanger<String> exchanger;
    String            name;

    public ExchangeTest(Exchanger exchanger, String name) {
        this.exchanger = exchanger;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            String exchange = exchanger.exchange(name);
            System.out.println(name + "线程：" + exchange);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        ExchangeTest testA = new ExchangeTest(exchanger, "A");
        ExchangeTest testB = new ExchangeTest(exchanger, "B");
        new Thread(testA).start();
        new Thread(testB).start();
    }
}
