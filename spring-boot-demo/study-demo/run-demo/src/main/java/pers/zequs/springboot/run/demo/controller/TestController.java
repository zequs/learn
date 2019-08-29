package pers.zequs.springboot.run.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.zequs.springboot.run.demo.model.User;
import pers.zequs.springboot.starter.demo.dao.ZequsDao;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private ZequsDao zequsDao;

    @GetMapping("/test")
    public List<User> test() {
        List<User> users = zequsDao.sql("select * from tb_user", User.class);
        return users;
    }
}