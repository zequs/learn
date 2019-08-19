package com.zequs.demo.se.mapstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 15 Exp $
 */
@RestController
public class Constroller {

    @Autowired
    PersonConverter converter;

    @GetMapping("/mapstruct/test")
    public String test() {
        User user = new User();
        user.setAge(18);
        Person person = new Person();
        person.setId(1L);
        person.setName("张三");
        person.setBirthday(new Date());
        person.setUser(user);

        PersonDTO dto = converter.order2res(person);
        System.out.println(dto.toString());
        return dto.toString();
    }
}
