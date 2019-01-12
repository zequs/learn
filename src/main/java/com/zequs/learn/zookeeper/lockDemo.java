package com.zequs.learn.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;

import java.util.concurrent.CountDownLatch;

public class lockDemo {
    public static void main(String args[]) throws Exception {
        String CONNECT_ADDR = "127.0.0.1:2181";
        CuratorFramework curatorFramework=CuratorFrameworkFactory.builder().connectString(CONNECT_ADDR).build();
        InterProcessMutex interProcessMutex=new InterProcessMutex(curatorFramework,"/locks2");
        CountDownLatch countDownLatch=new CountDownLatch(10);
        for(int i=0;i<10;i++){
            new Thread(()->{
                try {
                    interProcessMutex.acquire();
                    System.out.println(Thread.currentThread().getName()+ "---------");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        interProcessMutex.release();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            },"Thread-"+i).start();
            countDownLatch.countDown();
        }
    }
}
