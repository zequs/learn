package pers.zequs.springboot.listener.demo.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import pers.zequs.springboot.listener.demo.event.MyEvent;

/**
 * 监听事件实现方式四：在application.properties中配置监听器
 */
public class MyListener4 implements ApplicationListener<MyEvent>
{

    public void onApplicationEvent(MyEvent event)
    {
        System.out.println("监听事件4：");
    }
}
