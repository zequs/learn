package com.zequs.learn.se.concurent;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class CompletableFutureDemo {
    public static void main(String args[]) {
        List<CompletableFuture> list = Lists.newArrayList();
        CompletableFuture<Object> future = CompletableFuture.anyOf((CompletableFuture[])list.toArray());
        CompletableFuture completableFuture = null;
    }
}
