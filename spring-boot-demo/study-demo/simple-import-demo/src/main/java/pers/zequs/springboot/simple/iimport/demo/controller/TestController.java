package pers.zequs.springboot.simple.iimport.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import pers.zequs.springboot.simple.iimport.demo.model.Person;
import pers.zequs.springboot.simple.iimport.demo.model.User;

/**
 * @author zequs
 * @version $Id: study-demo-parent, v0.1 2019 08 27 Exp $
 */
@RestController
public class TestController {

    @Autowired
    private User   user;

    @Autowired
    private Person person;

    @GetMapping("/test/user")
    public User test() {
        return user;
    }
    @GetMapping("/test/person")
    public Person person() {
      person.setName("person-zhangsan");
        return person;
    }
}
