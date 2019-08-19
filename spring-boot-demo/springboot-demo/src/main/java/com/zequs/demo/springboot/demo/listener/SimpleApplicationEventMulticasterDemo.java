package com.zequs.demo.springboot.demo.listener;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.event.SimpleApplicationEventMulticaster;

/**
 * @author zequs
 * @version $Id: spring-boot-demo, v0.1 2019 07 27 Exp $
 */

@SpringBootApplication
public class SimpleApplicationEventMulticasterDemo {
    public static void main(String[] args) {
        SimpleApplicationEventMulticaster multicaster = new SimpleApplicationEventMulticaster();
        multicaster.addApplicationListener(new ApplicationListener<MyEvent>() {
            @Override
            public void onApplicationEvent(MyEvent event) {
                System.err.println("监听事件：" + event);
            }
        });

        multicaster.multicastEvent(new MyEvent("hello world"));

    }
}
