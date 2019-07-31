package com.zequs.demo.se.designpattern.pattern.singletion.type9;

import java.io.ObjectStreamException;

/**
 *
 * 双重检查
 * 在双重检查基础上，处理反射和克隆创建对象，
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 07 31 Exp $
 */
public class Singleton {

    private  static volatile Singleton instance =  null;

    //防止反射创建对象
    private Singleton() {
        if (instance != null) {
            throw new RuntimeException();
        }
    }
    // 防止反序列化获取多个对象的漏洞。
    // 无论是实现Serializable接口，或是Externalizable接口，当从I/O流中读取对象时，readResolve()方法都会被调用到。
    // 实际上就是用readResolve()中返回的对象直接替换在反序列化过程中创建的对象。
    private Object readResolve() throws ObjectStreamException {
        return instance;
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {

    }

}
