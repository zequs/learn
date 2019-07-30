package org.springframework.boot.zequs.demo;

import org.springframework.boot.SpringApplication;

/**
 * @author zequs
 * @version $Id: spring-boot-build, v0.1 2019 07 26 Exp $
 */
public class Test {
	public static void main(String[] args) {
		SpringApplication application = new SpringApplication();
		String[] a = {"server.port=8888","author=zequs","--env=dev","--spring.profiles.active=${env}"};
		args = a;
		SpringApplication.run(Test.class, args);
	}
}
