package com.zequs.demo.se.designpattern.pattern.proxy.statics;

/**
 * 代理对象和被代理对象都需要实现接口，虽说用不用接口都一样。
 * 1.不实现同一个接口，像委派模式
 * 2.代理对象具有和被代理对象具有一样的契约。体现了“代理”的概念
 * 参考https://www.iteye.com/problems/38734
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 06 Exp $
 */
public class Client {
    public static void main(String[] args) {
        Target target = new Target();
        Proxy proxy = new Proxy(target);
        proxy.play();
    }
}
