package com.zequs.demo.se;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@SpringBootApplication
public class SeDemoApplication {

	public static void main(String[] args) {
//		SpringApplication.run(SeDemoApplication.class, args);
		SpringApplication application = new SpringApplication(SeDemoApplication.class);
		Properties properties = new Properties();
		properties.setProperty("server.port","8082");
		application.setDefaultProperties(properties);
//		Map<String, Object> map = new HashMap<>();
//		map.put("server.port","8088");
//		application.setDefaultProperties(map);
		application.run(args);
	}

}
