package com.zequs.demo.eureka.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EurekaFeignProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaFeignProviderApplication.class, args);
	}

}
