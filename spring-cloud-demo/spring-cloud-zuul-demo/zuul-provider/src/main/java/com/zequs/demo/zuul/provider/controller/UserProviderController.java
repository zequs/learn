package com.zequs.demo.zuul.provider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 小马哥 QQ 1191971402
 * @copyright 咕泡学院出品
 * @since 2017/11/5
 */
@RestController
public class UserProviderController {

    /**
     * 保存
     *
     * @return 如果成功，<code>true</code>
     */
    @GetMapping("/user/say")
    public String sayHello() {
        return "user hello world!!!";
    }

    @PostMapping("/user/hello")
    public String hello() {
        return "say hello";
    }

}
