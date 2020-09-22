package com.zequs.demo.se.jvm;

/**
 * @author zequs
 * @version : se-demo, v0.1 2020 09 01 Exp $
 */
public class ClassLoaderTest1 {

    /**
     * 各个类的加载器
     */
    public static void m1() {
        System.out.println(String.class.getClassLoader()); //null
        System.out.println(sun.net.spi.nameservice.dns.DNSNameService
                .class.getClassLoader()); //sun.misc.Launcher$ExtClassLoader
        System.out.println(ClassLoaderTest1.class.getClassLoader());//sun.misc.Launcher$AppClassLoader
    }

    /**
     * 加载器的父类加载器
     */
    public static void classLoaderParent() {
//        System.out.println(String.class.getClassLoader().getParent());
        System.out.println(sun.net.spi.nameservice.dns.DNSNameService.class.getClassLoader().getParent());//null
        System.out.println(ClassLoaderTest1.class.getClassLoader().getParent());//sun.misc.Launcher$ExtClassLoader
    }

    /**
     * 加载器的加载器
     */
    public static void classLoaderOfClassLoader() {
        System.out.println(sun.net.spi.nameservice.dns.DNSNameService.class.getClassLoader().getClass().getClassLoader());//null
        System.out.println(ClassLoaderTest1.class.getClassLoader().getClass().getClassLoader());//sun.misc.Launcher$ExtClassLoader
    }

    /**
     * 各个类加载器加载路径
     * 加载器加载路径都是sun.misc.Launcher这个类中
     */
    public static void  classLoaderPath() {
        String bootPath = System.getProperty("sun.boot.class.path");
        System.out.println(bootPath.replaceAll(";",System.lineSeparator()));
        System.out.println("=======================================");
        String extPath = System.getProperty("java.ext.dirs");
        System.out.println(extPath.replaceAll(";",System.lineSeparator()));
        System.out.println("=======================================");
        String classPathPath = System.getProperty("java.class.path");
        System.out.println(classPathPath.replaceAll(";",System.lineSeparator()));
    }

    public static void main(String[] args) {
        classLoaderPath();
    }
}
