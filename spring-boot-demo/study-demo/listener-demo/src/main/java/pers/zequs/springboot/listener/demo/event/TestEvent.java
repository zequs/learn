package pers.zequs.springboot.listener.demo.event;

import org.springframework.context.ApplicationEvent;

public class TestEvent extends ApplicationEvent {
    /**
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public TestEvent(Object source) {
        super(source);
    }
}
