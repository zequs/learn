package com.zequs.demo.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ZookeeperClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZookeeperClientApplication.class, args);
	}

}
