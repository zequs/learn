package com.zequs.learn.se;

public class Test2 {
    public static void main(String args[]) {

        String s1 = new StringBuilder().append("String").append("Test").toString();
        System.out.println(s1 == s1.intern());

          /* System.out.println(System.identityHashCode(s1));
        System.out.println("===============");
        System.out.println(System.identityHashCode(s11));
        String s2 = new StringBuilder().append("Ja").append("va").toString();
        System.out.println(s2 == s2.intern());*/


        String s11 = new String("1");    // 同时会生成堆中的对象 以及常量池中1的对象，但是此时s1是指向堆中的对象的
        String s3 = s11.intern();            // 常量池中的已经存在
        String s2 = "1";
        System.out.println(s11 == s2);    // false
        System.out.println(s3 == s2);    // true
    }
}
