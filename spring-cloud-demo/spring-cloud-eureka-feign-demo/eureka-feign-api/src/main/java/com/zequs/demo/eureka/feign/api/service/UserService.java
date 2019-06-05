package com.zequs.demo.eureka.feign.api.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zequs
 * @version $Id: spring-cloud-demo-parent, v0.1 2019 05 23 Exp $
 */
@FeignClient(name = "user-service")
public interface UserService {

    @RequestMapping("/user/say.json")
    public String say();

    @PostMapping("/user/hello")
    public String hello(@RequestBody Person person);
}

