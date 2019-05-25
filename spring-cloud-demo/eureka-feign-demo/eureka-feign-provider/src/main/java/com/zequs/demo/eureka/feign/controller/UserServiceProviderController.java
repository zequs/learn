package com.zequs.demo.eureka.feign.controller;

import com.zequs.demo.eureka.feign.api.domain.Person;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserServiceProviderController {
    @RequestMapping(value = "/user/hello")
    public String hello(@RequestBody Person person) {
        return "hello world!!";
    }
}
