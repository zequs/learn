package com.zequs.learn.rmi;

import sun.plugin2.liveconnect.RemoteJavaObject;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * 第二步：实现接口，继承UnicastRemoteObject类，显现抛出RemoteException异常的构造方法
 */
public class ServiceImpl extends UnicastRemoteObject implements Service {

    protected ServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public String sayHello(String msg) throws RemoteException{
        return "hello," + msg;
    }

}
