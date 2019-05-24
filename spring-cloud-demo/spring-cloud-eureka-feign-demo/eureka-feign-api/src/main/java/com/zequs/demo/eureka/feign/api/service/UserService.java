package com.zequs.demo.eureka.feign.api.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zequs
 * @version $Id: spring-cloud-demo-parent, v0.1 2019 05 23 Exp $
 */
@FeignClient(path = "user", name = "user-service")
public interface UserService {

    @RequestMapping("/say")
    public String say();
}
