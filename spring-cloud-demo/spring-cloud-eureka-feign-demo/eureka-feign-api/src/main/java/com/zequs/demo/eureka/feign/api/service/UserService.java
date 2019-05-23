package com.zequs.demo.eureka.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author zequs
 * @version $Id: spring-cloud-demo-parent, v0.1 2019 05 23 Exp $
 */
@FeignClient(value = "User-service")
public interface UserService {

    @GetMapping("/user/say")
    public String say();
}
