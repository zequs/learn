package com.zequs.demo.springbootdemo;

import com.zequs.demo.springboot.demo.bean.Zequs;
import com.zequs.demo.springboot.demo.listener.ListenerDemo;
import com.zequs.demo.springboot.demo.listener.TestEvent;
import com.zequs.demo.springboot.demo.listener.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.zequs.demo.springboot.demo")
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =SpringApplication.run(SpringBootDemoApplication.class, args);
		Zequs zequs = (Zequs) context.getBean("zequsa");
		System.out.println(zequs.getName());
	}

}
