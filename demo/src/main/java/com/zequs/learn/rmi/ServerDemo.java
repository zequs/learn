package com.zequs.learn.rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class ServerDemo {
    public static void main(String args[]) {
        try {
            /**
             * 创建了ServiceImpl_stub对象,ServiceImpl的代理对象
             */
            ServiceImpl service = new ServiceImpl();
            //注册
            /**
             * 创建了RegistryImpl_stub对象
             * 创建socket，并对1099端口进行进行监听
             */
            LocateRegistry.createRegistry(1099);
            //第三部发布rmi服务
            //把service绑定到rmi协议地址上。
            Naming.rebind("rmi://localhost:1099/hello",service);
            System.out.println("---------------服务器已启动-----------------");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
}
