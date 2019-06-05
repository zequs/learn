package com.zequs.demo.eureka.feign.controller;

import com.zequs.demo.eureka.feign.api.service.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 小马哥 QQ 1191971402
 * @copyright 咕泡学院出品
 * @since 2017/11/5
 */
@RestController
public class UsererviceProviderController {

    /**
     * 保存
     *
     * @return 如果成功，<code>true</code>
     */
    @GetMapping("/user/say.json")
    public String sayHello() {
        return "user hello world!!!";
    }
    @PostMapping("/user/hello")
    public String hello(@RequestBody Person person) {
        return "say hello";
    }

}
