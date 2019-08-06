package com.zequs.demo.se.designpattern.pattern.bridge;

/**
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 02 Exp $
 */
public class UpRightPhone extends Phone {

    public UpRightPhone(Brand brand) {
        super(brand);
    }

     public void open() {
        super.open();
         System.out.println("样式开机");
     }

     public void close() {
        super.close();
         System.out.println("样式关机");
     }

     public void call() {
        super.call();
         System.out.println("样式打电话");
     }
}
