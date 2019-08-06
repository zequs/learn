package com.zequs.demo.se.designpattern.pattern.facade;

/**
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 06 Exp $
 */
public class Client {
    public static void main(String[] args) {
        HomeTemplateFacade facade = new HomeTemplateFacade();
        facade.ready();
        System.out.println("-------------------");
        facade.play();
        System.out.println("-------------------");
        facade.pause();
        System.out.println("-------------------");
        facade.end();
    }
}
