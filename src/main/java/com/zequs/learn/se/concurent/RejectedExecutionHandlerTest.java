package com.zequs.learn.se.concurent;

import sun.misc.Queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class RejectedExecutionHandlerTest implements RejectedExecutionHandler {

    //假设为堵塞队列
    ArrayBlockingQueue queue = new ArrayBlockingQueue(1);

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        try {
            //put默认是队列满了，自动回堵塞在那里，只到队列有空位才行。
            //and的话若超出了度列的长度会直接抛出异常
            //take:若队列为空，发生阻塞，等待有元素。
            //poll: 若队列为空，返回null。
            //remove:若队列为空，抛出NoSuchElementException异常。
            //take:若队列为空，发生阻塞，等待有元素。
            queue.put(r);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
