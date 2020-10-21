package com.zequs.springboot.demo.manager;

import com.zequs.springboot.demo.model.User;

/**
 * @author zequs
 * @version : springboot-mvc-demo, v0.1 2020 09 30 Exp $
 */
public interface UserManager {

    public User getUser(Integer id);
}
