package pers.zequs.springboot.listener.demo.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import pers.zequs.springboot.listener.demo.event.MyEvent;

/**
 * 监听事件实现方式二：bean的方式放入spring容器中
 */
@Component
public class MyListener2 implements ApplicationListener<MyEvent>
{

    public void onApplicationEvent(MyEvent event)
    {
        System.out.println("监听事件：");
    }
}
