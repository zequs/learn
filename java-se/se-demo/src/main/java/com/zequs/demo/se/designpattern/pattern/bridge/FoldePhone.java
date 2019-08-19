package com.zequs.demo.se.designpattern.pattern.bridge;

/**
 * 桥梁
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 02 Exp $
 */
public class FoldePhone extends Phone {

    public FoldePhone(Brand brand) {
        super(brand);
    }

     public void open() {
        super.open();
         System.out.println("折叠开机");
     }

     public void close() {
        super.close();
         System.out.println("折叠关机");
     }

     public void call() {
        super.call();
         System.out.println("折叠打电话");
     }
}
