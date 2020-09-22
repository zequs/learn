package com.zequs.demo.se.jvm;

public class Test {
    public static void main(String[] args) {
        MyClassLoader myClassLoader = new MyClassLoader("D:\\zequs\\learn\\learn\\java-se\\se-demo\\src\\main\\java\\com\\zequs\\demo\\se\\jvm\\HelloWorld");
        try {
            Class clazz = myClassLoader.findClass("com.zequs.demo.se.jvm.HelloWorld");
            System.out.println(clazz);
            System.out.println(clazz.getConstructor().newInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}