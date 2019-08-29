package pers.zequs.springboot.listener.demo;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.support.GenericApplicationContext;
import pers.zequs.springboot.listener.demo.event.TestEvent;

/**
 * @author zequs
 * @version $Id: spring-boot-demo, v0.1 2019 07 27 Exp $
 */
public class SpringEvnetListenceDemo {

    public static void main(String[] args) {
        GenericApplicationContext context = new GenericApplicationContext();

        /**
         * 监听全部事件
         * @param event
         * ContextRefreshedEvent springRefresh事件
         * PayloadApplicationEvent helloWorld事件
         * ContextClosedEvent ContextClosed事件
         * MyEvent 自定义事件
         *
         */
        context.addApplicationListener(new ApplicationListener<ApplicationEvent>() {

            @Override
            public void onApplicationEvent(ApplicationEvent event) {
                System.err.println("监听事件：" + event);
            }
        });

        /**
         * 监听单个ContextClosedEvent事件
         */
        context.addApplicationListener(new ApplicationListener<ContextClosedEvent>() {
            @Override
            public void onApplicationEvent(ContextClosedEvent event) {
                System.out.println("触发了关闭上下文事件");
            }
        });

        /**
         * 监听单个MyEvent事件
         */
        context.addApplicationListener(new ApplicationListener<TestEvent>() {
            @Override
            public void onApplicationEvent(TestEvent event) {
                System.out.println("触发了自定义事件");
            }
        });

        //spring 容器refresh
        context.refresh();
        //发布事件
        context.publishEvent("Hello world");
        //发布自定义事件
        context.publishEvent(new TestEvent("test event"));
        //会触发ContextClosed事件
        context.close();
    }
}
