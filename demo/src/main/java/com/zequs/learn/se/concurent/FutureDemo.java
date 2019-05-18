package com.zequs.learn.se.concurent;


import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.*;

/**
 *
 */
public class FutureDemo {

    Callable callable1 = () ->"hello world!!!"; //lamabda表达式

    public FutureTask FutureTaskUse () {
        FutureTask task = new FutureTask(callable1);
        return task;
    }

    public List<Future> threadPollSubmit(int threadNum) {
        Callable callable = new Callable() {
            @Override
            public Object call() throws Exception {
                return "hello world!!";
            }
        };

        List list = Lists.newArrayList();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 0; i < threadNum; i++) {
            Future future = executorService.submit(callable1);
            list.add(future);
        }
        return list;
    }

    public static void main(String args[]) throws Exception{
        FutureDemo futureTest = new FutureDemo();
        FutureTask future = futureTest.FutureTaskUse();
        new Thread(future).start();
        System.out.println(future.get());

        System.out.println("------------------------------------------");
        List<Future> futures = futureTest.threadPollSubmit(5);
        futures.forEach((f) -> {
            try {
                System.out.println(f.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });

    }


}
