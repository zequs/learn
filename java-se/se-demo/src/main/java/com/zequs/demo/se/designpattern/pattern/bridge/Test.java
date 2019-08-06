package com.zequs.demo.se.designpattern.pattern.bridge;

/**
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 02 Exp $
 */
public class Test {
    public static void main(String[] args) {
        Phone phone = new FoldePhone(new XiaoMiBrand());
        phone.call();
        phone.open();
        phone.close();
    }
}
