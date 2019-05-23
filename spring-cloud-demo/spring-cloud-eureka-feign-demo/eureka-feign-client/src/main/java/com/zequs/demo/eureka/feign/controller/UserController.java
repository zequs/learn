package com.zequs.demo.eureka.feign.controller;

import com.zequs.demo.eureka.feign.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author zequs
 * @version $Id: spring-cloud-demo-parent, v0.1 2019 05 23 Exp $
 */
@RestController
public class UserController implements UserService {
    @Value("${server.port}")
    private String port;

    private RestTemplate restTemplate;

    @Autowired
    private UserService userService;


    public String say() {
        System.out.println("端口是：" + port);
        return restTemplate.getForObject("http://eureka-client/say", String.class);
    }
}
