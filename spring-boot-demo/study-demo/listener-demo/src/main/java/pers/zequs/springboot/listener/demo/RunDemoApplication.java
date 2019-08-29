package pers.zequs.springboot.listener.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import pers.zequs.springboot.listener.demo.event.MyEvent;

@SpringBootApplication
public class RunDemoApplication {

	public static void main(String[] args) {

		SpringApplication application = new SpringApplication(RunDemoApplication.class);
		application.addListeners(new ApplicationListener<MyEvent>() {
			@Override
			public void onApplicationEvent(MyEvent event) {
				System.err.println("监听事件1：" + event);
			}
		});

		ConfigurableApplicationContext context = application.run(args);
		context.publishEvent(new MyEvent("发布事件"));
	}

}
