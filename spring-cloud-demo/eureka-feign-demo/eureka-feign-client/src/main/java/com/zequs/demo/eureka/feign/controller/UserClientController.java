package com.zequs.demo.eureka.feign.controller;

import com.zequs.demo.eureka.feign.api.domain.Person;
import com.zequs.demo.eureka.feign.api.service.PersonService;
import com.zequs.demo.eureka.feign.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * {@link UserClientController} 实现 {@link PersonService}
 *
 * @author 小马哥 QQ 1191971402
 * @copyright 咕泡学院出品
 * @since 2017/11/5
 */
@RestController
public class UserClientController implements UserService {

    @Autowired
    private UserService userService;


    @Override
    public String save(@RequestBody Person person) {
        return userService.save(person);
    }

}
