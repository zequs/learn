package pers.zequs.springboot.run.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SimpleEnableDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleEnableDemoApplication.class, args);
		System.out.println(11);
	}

}
