package com.zequs.learn.se.concurent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsTest {

    public static void main(String args[]) {
        ExecutorService FixedExecutorService = Executors.newFixedThreadPool(4);
    }
}
