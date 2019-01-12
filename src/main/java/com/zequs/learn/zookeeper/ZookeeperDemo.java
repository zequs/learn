package com.zequs.learn.zookeeper;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;

public class ZookeeperDemo {
    public final static String ROOT_PATH = "/zequs";

    public static void main(String args[]) throws IOException, KeeperException, InterruptedException {
        String connetString = "127.0.0.1:2181";

        int timeout = 4000;
        ZooKeeper zooKeeper = new ZooKeeper(connetString, timeout, null);
        String result = zooKeeper.create(ROOT_PATH + "/h","0".getBytes(),ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
        System.out.println("create resutl :" + result);
        Stat stat  = new Stat();
        System.out.println("--------------------");
        byte[] data =  zooKeeper.getData(result, null, stat);
        System.out.println("data:" + new String(data));

        zooKeeper.delete(result, stat.getVersion());
        zooKeeper.delete("/zequs/f", stat.getVersion());
        zooKeeper.close();
        System.in.read();
    }
}
