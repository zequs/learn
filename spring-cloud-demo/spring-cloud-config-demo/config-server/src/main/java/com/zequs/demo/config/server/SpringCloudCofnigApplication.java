package com.zequs.demo.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpringCloudCofnigApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudCofnigApplication.class, args);
	}

}
