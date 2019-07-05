package com.zequs.demo.dubbo.consumer.Controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zequs.demo.dubbo.server.api.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zequs
 * @version $Id: springboot-dubbo-demo, v0.1 2019 07 05 Exp $
 */
@RestController
public class TestController {

    @Reference
    private UserService userService;

    @GetMapping("/getUser")
    public Object getUer(Integer id) {

        return userService.getUser(id);
    }
}
