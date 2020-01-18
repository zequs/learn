package com.zequs.demo.concurrent.demo;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author zequs
 * @version $Id: concurrent-Demo, v0.1 2019 07 24 Exp $
 */
public class MyRejectedExecutionHandler  implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {

        //TODO
    }
}
