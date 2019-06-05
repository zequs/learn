package com.zequs.demo.user.service.api.service;

import com.zequs.demo.user.service.api.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zequs
 * @version $Id: user-service-parent, v0.1 2019 05 27 Exp $
 */

@FeignClient(name = "user-provider")
public interface UserService {
    @RequestMapping(value = "/user/hello")
    public String save(@RequestBody User person);
}
