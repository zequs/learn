package com.zequs.demo.vola;

import java.util.concurrent.TimeUnit;

/**
 * flag变量用static修饰也能保证可见性？
 * @author zequs
 * @version : concurrent-demo, v0.1 2020 11 06 Exp $
 */
public class VolatileTest extends Thread {

    private static boolean flag = false;

    @Override
    public void run() {
        int i = 0;
        while (true) {
            if (flag) {
                break;
            }
            System.out.println(i++);
        }
    }
    public static void main(String[] args) throws Exception {
        VolatileTest test = new VolatileTest();
        test.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("=====================================================================");
        flag = true;
    }

}
