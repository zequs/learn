package com.zequs.demo.eureka.feign.controller;

import com.zequs.demo.eureka.feign.api.service.Person;
import com.zequs.demo.eureka.feign.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zequs
 * @version $Id: spring-cloud-demo-parent, v0.1 2019 05 23 Exp $
 */
@RestController
public class UserController implements UserService{
    @Value("${server.port}")
    private String port;

    @Autowired
    private UserService userService;


    public String say() {
        System.out.println("端口是：" + port);
       return userService.say();
    }

    public String hello(@RequestBody Person person) {
        return userService.hello(person);
    }
}
