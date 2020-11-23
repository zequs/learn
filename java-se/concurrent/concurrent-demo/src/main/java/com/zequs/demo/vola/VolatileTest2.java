package com.zequs.demo.vola;

import java.util.concurrent.TimeUnit;

/**
 * @author zequs
 * @version : concurrent-demo, v0.1 2020 11 06 Exp $
 */
public class VolatileTest2 {

   volatile boolean flag = true;
    public void m() {
        int i = 0;
        System.out.println("m() start");
        while (flag) {
            System.out.println(i++);
        }
        System.out.println("m() end");
    }
    public static void main(String[] args) throws Exception {
        VolatileTest2 test = new VolatileTest2();
        new Thread( test::m).start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("==========================================================");
        test.flag = true;
    }

}
