package com.zequs.springboot.demo.controller;

import com.zequs.springboot.demo.manager.UserManager;
import com.zequs.springboot.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zequs
 * @version : springboot-mvc-demo, v0.1 2020 09 30 Exp $
 */
@RestController
public class UserController {

    @Autowired
    private UserManager userManager;

    @GetMapping("/user/getUserById")
    public User getUserById(Integer id) {
        if (id == null) {
            return null;
        }
        return userManager.getUser(id);
    }
    @GetMapping("/user/getUser")
    public User getUser(User user) {
        if (user != null) {
            return user;
        }
        return null;
    }
    @GetMapping("/user/getUser2")
    public User getUser2(@RequestParam User user) {
        if (user != null) {
            return user;
        }
        return null;
    }


}
