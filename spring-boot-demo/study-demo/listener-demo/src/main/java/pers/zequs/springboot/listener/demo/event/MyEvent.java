package pers.zequs.springboot.listener.demo.event;

import org.springframework.context.ApplicationEvent;

/**
 * 自定义事件
 * @author zequs
 * @version $Id: spring-boot-demo, v0.1 2019 07 27 Exp $
 */
public class MyEvent extends ApplicationEvent {
    public MyEvent(Object source) {
        super(source);
    }
}
