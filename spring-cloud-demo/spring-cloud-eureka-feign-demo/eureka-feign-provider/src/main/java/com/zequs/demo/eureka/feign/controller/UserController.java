package com.zequs.demo.eureka.feign.controller;

import com.zequs.demo.eureka.feign.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zequs
 * @version $Id: spring-cloud-demo-parent, v0.1 2019 05 23 Exp $
 */
@RestController
public class UserController {


    @GetMapping("/user/say")
    public String say() {
        return "hello world!!! ";
    }
}
