package com.zequs.demo.user.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * User Client 应用程序
 *
 * @author 小马哥 QQ 1191971402
 * @copyright 咕泡学院出品
 * @since 2017/11/5
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages="com.zequs.demo.user.service.api.service")
public class UserClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserClientApplication.class,args);
    }
}
