package com.zequs.learn.se.jvm;

/**
 * 执行顺序
 */
public class ExecutionSequence {
    public static int k = 0;
    public static ExecutionSequence t1 = new ExecutionSequence("t1");
    public static ExecutionSequence t2 = new ExecutionSequence("t2");
    public static int i = print("i");
    public static int n = 99;
    public int j = print("j");

    {
        print("构造块");
    }
    static {
        print("静态块");
    }

    public ExecutionSequence(String str) {
        System.out.println((++k) + ":" + str + "   i=" + i + "    n=" + n);
        ++i;
        ++n;
    }

    public static int print(String str) {
        System.out.println((++k) + ":" + str + "   i=" + i + "    n=" + n);
        ++n;
        return ++i;
    }

    public static void main(String args[]) {
        ExecutionSequence t = new ExecutionSequence("init");
    }
}
