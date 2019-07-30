package com.zequs.demo.springbootjardemo.jar;

import com.zequs.demo.springbootjardemo.demo.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JarDemoApplication {


    /**
     * ConfigurationProperties测试
     * @return
     */
	@Bean
	@ConfigurationProperties(prefix = "zequs.config")
	public Config config() {
		return new Config();
	}
	public static void main(String[] args) {
        SpringApplication application = new SpringApplication();
        String[] a = {"server.port=8888","author=zequs","--env=dev","--spring.profiles.active=${env}"};
        args = a;
        SpringApplication.run(JarDemoApplication.class, args);
    }

}
