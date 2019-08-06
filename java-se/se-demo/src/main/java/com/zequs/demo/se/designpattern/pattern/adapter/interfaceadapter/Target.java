package com.zequs.demo.se.designpattern.pattern.adapter.interfaceadapter;

/**
 * 只使用到了m2方法，InterfaceAdapter帮我们全部实现了Interface1的接口，
 * 如果我只用到m2方法，只需要实现自己的m2方法，其他方法不需要再实现了
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 01 Exp $
 */
public class Target extends InterfaceAdapter {
    @Override
    public void m2() {
        System.out.println("实现自己的m2方法");
    }
}
