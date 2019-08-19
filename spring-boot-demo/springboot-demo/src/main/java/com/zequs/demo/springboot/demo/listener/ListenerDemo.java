package com.zequs.demo.springboot.demo.listener;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class ListenerDemo {

    /**
     * @param event
     * @Async监听方法可以设置为异步
     */
    @EventListener
    @Async
    public void listenerEvent(TestEvent event) {
        System.out.println("监听事件1:" + event.getSource());
    }

    @EventListener
    @Async
    public void listenerEventUser(User user) {
        System.out.println("监听事件2:" + user.getName());
    }
}
