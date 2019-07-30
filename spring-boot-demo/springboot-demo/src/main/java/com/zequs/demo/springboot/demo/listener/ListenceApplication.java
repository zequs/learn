package com.zequs.demo.springboot.demo.listener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author zequs
 * @version $Id: spring-boot-demo, v0.1 2019 07 27 Exp $
 */
@SpringBootApplication
public class ListenceApplication {

    public static void main(String[] args) {

        SpringApplication application = new SpringApplication(ListenceApplication.class);
        application.addListeners(new ApplicationListener<ApplicationEvent>() {
            @Override
            public void onApplicationEvent(ApplicationEvent event) {
                System.err.println("监听事件：" + event);
            }
        });
        application.run(args);
    }
}
