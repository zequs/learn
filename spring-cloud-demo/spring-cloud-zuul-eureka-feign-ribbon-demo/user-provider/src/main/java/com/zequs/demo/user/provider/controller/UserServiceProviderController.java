package com.zequs.demo.user.provider.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zequs.demo.user.service.api.domain.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class UserServiceProviderController {


    @RequestMapping(value = "/user/hello")
    @HystrixCommand(fallbackMethod = "fallbackHello", commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "100")})
    public String hello(@RequestBody User user) throws InterruptedException {
        Random random = new Random();
        int value = random.nextInt(200);
        Thread.sleep(value);
        return "hello world!!";
    }

    public String fallbackHello(@RequestBody User user) {
        return "fail hello!";
    }
}
