package com.zequs.learn.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 第一步：定义接口，实现Remote
 */
public interface Service extends Remote {
    String sayHello(String msg) throws RemoteException;
}
