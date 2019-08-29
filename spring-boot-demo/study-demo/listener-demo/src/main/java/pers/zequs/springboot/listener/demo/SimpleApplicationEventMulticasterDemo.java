package pers.zequs.springboot.listener.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import pers.zequs.springboot.listener.demo.event.MyEvent;

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
                System.err.println("监听事件1：" + event);
            }
        });

        multicaster.multicastEvent(new MyEvent("hello world"));

    }
}
