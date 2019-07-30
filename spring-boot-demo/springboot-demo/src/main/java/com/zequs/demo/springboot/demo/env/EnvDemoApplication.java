package com.zequs.demo.springboot.demo.env;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EnvDemoApplication {


    /**
     * ConfigurationProperties测试
     *
     * @return
     */
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication();
        String[] a = {"server.port=8888", "author=zequs", "--env=dev", "--spring.profiles.active=${env}"};
        args = a;
        application.run(EnvDemoApplication.class, args);
    }

}
