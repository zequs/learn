package com.zequs.demo.reference;

/**
 * @author zequs
 * @version : concurrent-demo, v0.1 2020 11 09 Exp $
 */
public class M {
    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize");
        super.finalize();
    }
}
