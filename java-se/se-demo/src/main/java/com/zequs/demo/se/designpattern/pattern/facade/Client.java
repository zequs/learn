package com.zequs.demo.se.designpattern.pattern.facade;

/**
 * 外观模式：为子系统的一组接口提供一个一致的界面，比如，语音系统中只要说一声“睡觉了”，语音系统通过各种传感器做出（子系统）操作关闭窗帘，关上灯，关闭电视，空调调味睡眠模式等一系列操作
 *
 * 外观类：HomeTemplateFacade
 * 子系统：Light（灯），Popcorn，Projector，Screen，Sound，TVPlayer等
 * 睡觉了：外观类中的一个函数如ready()
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
