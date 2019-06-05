package com.zequs.demo.eureka.feign.controller;

import com.zequs.demo.eureka.feign.api.service.Person;
import feign.Param;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 小马哥 QQ 1191971402
 * @copyright 咕泡学院出品
 * @since 2017/11/5
 */
@RestController
public class PersonServiceProviderController {

    /**
     * 保存
     *
     * @return 如果成功，<code>true</code>
     */
    @RequestMapping("/person/say1")
    public String sayHello(@RequestParam("name") String name) {
        return "person hello world!!!" + name;
    }

    @RequestMapping("/person/sayHello")
    public String sayhello(@Param("name") String name) {
        return "person say hello!!!" + name;
    }

    @RequestMapping("/person/sayHelloWorld")
    public String sayHelloWorld(@RequestBody String name) {
        return "person say hello world!!!" + name;
    }

    @RequestMapping("/person/testObject")
    public String aaa(@RequestBody Person person) {
        return "testObject SUCCESS";
    }

}
