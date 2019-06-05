package com.zequs.demo.eureka.feign.api.service;

import com.zequs.demo.eureka.feign.api.domain.Person;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zequs
 * @version $Id: eureka-feign-parent, v0.1 2019 05 27 Exp $
 */
public interface UserService {
    @RequestMapping(value = "/user/hello")
    public String save(@RequestBody Person person);
}
