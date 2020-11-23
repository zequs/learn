package com.zequs.demo.markword;

import com.zequs.demo.model.Test;
import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.TimeUnit;

/**
 * 启用指针压缩:-XX:+UseCompressedOops（默认），禁止指针压缩:-XX:-UseCompressedOops
 * @author zequs
 * @version : concurrent-demo, v0.1 2020 07 17 Exp $
 */
public class MarkWordTest {
    public static void main(String[] args) {
        try {
            TimeUnit.SECONDS.sleep(7);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Object object = new Object();
//        System.out.println(ClassLayout.parseInstance(object).toPrintable());

        Test test = new Test();
        System.out.println(ClassLayout.parseInstance(test).toPrintable());
        Object[] objects = new Object[1024];
        System.out.println(ClassLayout.parseInstance(objects).toPrintable());
        Object[] objects1 = new Object[4];
        System.out.println(ClassLayout.parseInstance(objects1).toPrintable());

        System.out.println(ClassLayout.parseInstance(object).toPrintable());
    }
}
