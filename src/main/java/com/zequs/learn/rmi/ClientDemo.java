package com.zequs.learn.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ClientDemo {
    public static void main(String args[]) {
        try {
            //第四步：调用rmi服务
            Service service = (Service) Naming.lookup("rmi://localhost:1099/hello");
            System.out.println(service.sayHello("张三"));
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
