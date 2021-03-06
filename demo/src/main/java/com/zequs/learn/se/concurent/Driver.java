package com.zequs.learn.se.concurent;

import java.util.concurrent.CountDownLatch;

public class Driver { // ...
   public static void main(String args[]) throws Exception{
     CountDownLatch startSignal = new CountDownLatch(1);
     CountDownLatch doneSignal = new CountDownLatch(3);

     for (int i = 0; i < 3; ++i) // create and start threads
       new Thread(new Worker(startSignal, doneSignal)).start();

        doSomethingElse();            // don't let run yet
        startSignal.countDown();      // let all threads proceed
        doSomethingElse();
        doneSignal.await();           // wait for all to finish
   }

    private static void doSomethingElse() {
       System.out.println("------------------doSomethingElse------------------");
    }
}

 class Worker implements Runnable {
   private final CountDownLatch startSignal;
   private final CountDownLatch doneSignal;
   Worker(CountDownLatch startSignal, CountDownLatch doneSignal) {
      this.startSignal = startSignal;
      this.doneSignal = doneSignal;
   }
   public void run() {
      try {
        startSignal.await();
        doWork();
        doneSignal.countDown();
} catch (InterruptedException ex) {} // return;
   }

   void doWork() {
       System.out.println("------------------doWork------------------");
   }
 }