package com.zequs.demo.lock.reentrantlock;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 消费者生成者队列
 * @author zequs
 * @version : concurrent-demo, v0.1 2020 07 21 Exp $
 */
public class ProduceConsumerTest {



    public static  void  m1() {
        Queue queue = new LinkedBlockingQueue(100);
        Lock lock = new ReentrantLock();
        Condition producerCondition = lock.newCondition();
        Condition consumerCondition = lock.newCondition();
        int size = 100;
        new Thread(() -> {
            while (true) {
                lock.lock();
                if (queue.size() == 0) {
                    try {
                        consumerCondition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println(Thread.currentThread().getName() +"：消费者消费消息———————————————");
                    queue.poll();
                    try {
                        TimeUnit.MILLISECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    producerCondition.signal();
                }
                lock.unlock();
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            while (true) {
                lock.lock();
                if (queue.size() == 0) {
                    try {
                        consumerCondition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println(Thread.currentThread().getName() + "：消费者消费消息———————————————");
                    queue.poll();
                    try {
                        TimeUnit.MILLISECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    producerCondition.signal();
                }
                lock.unlock();
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            while (true) {
                lock.lock();
                if (queue.size() == size) {
                    try {
                        producerCondition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("生产者生产消息+++++++++");
                    queue.add(new Object());
                    try {
                        TimeUnit.MILLISECONDS.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    consumerCondition.signal();
                }
                lock.unlock();
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            while (true) {
                lock.lock();
                if (queue.size() == size) {
                    try {
                        producerCondition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("生产者生产消息+++++++++");
                    queue.add(new Object());
                    try {
                        TimeUnit.MILLISECONDS.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    consumerCondition.signal();
                }
                lock.unlock();
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static void main(String[] args) {
        m1();
    }



}
