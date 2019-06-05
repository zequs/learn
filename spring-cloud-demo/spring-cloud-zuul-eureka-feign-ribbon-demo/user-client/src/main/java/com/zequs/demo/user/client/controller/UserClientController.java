package com.zequs.demo.user.client.controller;

import com.zequs.demo.user.service.api.domain.User;
import com.zequs.demo.user.service.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * {@link UserClientController} 实现 {@link UserService}
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
    public String save(@RequestBody User user) {
        return userService.save(user);
    }

}
