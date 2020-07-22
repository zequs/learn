package com.zequs.demo.demo;

import com.zequs.demo.model.Test;
import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.TimeUnit;

/**
 * @author zequs
 * @version : concurrent-demo, v0.1 2020 07 17 Exp $
 */
public class Test1 {
    public static void main(String[] args) {
        Test test = new Test();
        Object object = new Object();
        System.out.println(ClassLayout.parseInstance(test).toPrintable());
        Object[] objects = new Object[1024];
        System.out.println(ClassLayout.parseInstance(objects).toPrintable());
        Object[] objects1 = new Object[4];
        System.out.println(ClassLayout.parseInstance(objects1).toPrintable());
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(ClassLayout.parseInstance(object).toPrintable());
    }
}
