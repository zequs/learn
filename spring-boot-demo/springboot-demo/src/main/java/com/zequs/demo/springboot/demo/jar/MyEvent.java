package com.zequs.demo.springboot.demo.jar;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class MyEvent {

    @EventListener
    @Async
    public void listenerEvent(MyEvent event) {
        System.out.println("监听事件MyEvent：" + event);
    }

}
