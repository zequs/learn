package pers.zequs.springboot.listener.demo.listener;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import pers.zequs.springboot.listener.demo.event.MyEvent;
import pers.zequs.springboot.listener.demo.event.TestEvent;
import pers.zequs.springboot.listener.demo.model.User;

/**
 * 监听方式实现方式三： @EventListener方式
 */
@Component
public class MyListener3 {

    /**
     * @param event
     * @Async监听方法可以设置为异步
     */
    @EventListener
    @Async
    public void listenerEvent(MyEvent event) {
        System.out.println("监听事件3-test:" + event.getSource());
    }

    @EventListener
    @Async
    public void listenerEventUser(User user) {
        System.out.println("监听事件3-user:" + user.getName());
    }
}
