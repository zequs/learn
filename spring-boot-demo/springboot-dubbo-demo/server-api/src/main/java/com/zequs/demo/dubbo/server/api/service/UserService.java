package com.zequs.demo.dubbo.server.api.service;

import com.zequs.demo.dubbo.server.api.model.User;

/**
 * @author zequs
 * @version $Id: springboot-dubbo-demo, v0.1 2019 07 05 Exp $
 */
public interface UserService {

    public User getUser(int id);

    public void SerUser(User user);
}