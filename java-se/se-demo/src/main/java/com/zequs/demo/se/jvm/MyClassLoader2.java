package com.zequs.demo.se.jvm;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author zequs
 * @version : se-demo, v0.1 2020 09 02 Exp $
 */
public class MyClassLoader2 extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        //要把class文件放在桌面
        File file = new File("D:\\work\\consumer-test\\src\\main\\java\\com\\example\\demo\\test\\Test.class");
//        File file = new File("aa");
        System.out.println(file.getPath());
        System.out.println(name);
        try {
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int b = 0;
            while ((b = fis.read()) != 0) {
                baos.write(b);
            }
            byte[] bytes = baos.toByteArray();
            baos.close();
            fis.close();
            return defineClass(name,bytes,0, bytes.length);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.findClass(name);
    }

    public static void main(String[] args) {
        ClassLoader l = new MyClassLoader2();
        Class<?> clazz = null;
        try {
//            clazz = l.loadClass("com.example.demo.test.Test");
            clazz = l.loadClass("com.zequs.demo.se.jvm.ClassLoaderTest1");
            System.out.println("111111111111");
            System.out.println(clazz.getClass());
            System.out.println(clazz.getClassLoader());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
