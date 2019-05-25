package com.zequs.demo.eureka.feign.api.service;

import feign.Headers;
import feign.Param;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zequs
 * @version $Id: spring-cloud-demo-parent, v0.1 2019 05 23 Exp $
 */
public interface PersonService {

    @RequestMapping("/person/say1")
    @Headers("Content-Type: application/json")
    public String say1(@RequestBody String name);

    @RequestMapping("/sayHello")
    @Headers("Content-Type: application/json")
    public String sayhello(@Param("name") String name);

    @RequestMapping("/sayHelloWorld")
    public String sayHelloWorld(@RequestBody String name);

    @RequestMapping("/testObject")
    public String aaa(@RequestBody Person person);
}
