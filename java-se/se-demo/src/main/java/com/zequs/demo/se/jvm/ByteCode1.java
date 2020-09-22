package com.zequs.demo.se.jvm;

/**
 * @author zequs
 * @version : se-demo, v0.1 2020 08 25 Exp $
 */
public class ByteCode1 {
    private String name;

    public ByteCode1() {
        name = "zhangsan";
    }

    public void  m1() {};

    public String  m2() {
        return "hello world";
    };
    static class  ByteCodeInner{
        String age = "10";

        public ByteCodeInner() {
            age = "20";
        }

        public static  String mmm() {
            return "hello world";
        }
    }
    public static void main(String[] args) {
        int i = 4;
        int j = 0;
        j = i++;
        System.out.println(ByteCodeInner.mmm());
        System.out.println(j);
    }
}
