package com.zequs.demo.eureka.feign.api.service;

import com.zequs.demo.eureka.feign.api.domain.Person;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


public interface UserService {

    @RequestMapping(value = "/user/hello")
    String save(@RequestBody Person person);
}
