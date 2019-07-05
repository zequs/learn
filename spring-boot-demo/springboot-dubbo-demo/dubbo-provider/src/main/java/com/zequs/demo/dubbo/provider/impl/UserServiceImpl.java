package com.zequs.demo.dubbo.provider.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zequs.demo.dubbo.server.api.model.User;
import com.zequs.demo.dubbo.server.api.service.UserService;

/**
 * @author zequs
 * @version $Id: springboot-dubbo-demo, v0.1 2019 07 05 Exp $
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public User getUser(int id) {
        User user = new User();
        user.setId(id);
        user.setName("zhangsan");
        user.setAge(18);
        return user;
    }

    @Override
    public void SerUser(User user) {
        System.out.println(user.toString());
    }
}
