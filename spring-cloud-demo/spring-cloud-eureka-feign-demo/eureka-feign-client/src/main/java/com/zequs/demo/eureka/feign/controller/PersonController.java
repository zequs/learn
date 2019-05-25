package com.zequs.demo.eureka.feign.controller;

import com.zequs.demo.eureka.feign.api.service.Person;
import com.zequs.demo.eureka.feign.api.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zequs
 * @version $Id: spring-cloud-demo-parent, v0.1 2019 05 23 Exp $
 */

@RestController
public class PersonController implements PersonService{
    @Value("${server.port}")
    private String port;

    @Autowired
    private PersonService personService;


    public String say1(@RequestBody String name) {
        System.out.println("端口是：" + port);
       return personService.say1(name);
    }
    public String sayhello(@RequestBody String name) {
        return personService.sayhello(name);
    }
    public String sayHelloWorld(String name) {
        return personService.sayHelloWorld(name);
    }

    public String aaa(@RequestBody Person person){
        return  personService.aaa(person);
    }

}
