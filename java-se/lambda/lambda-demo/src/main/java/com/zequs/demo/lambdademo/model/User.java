package com.zequs.demo.lambdademo.model;

import lombok.Data;
import org.springframework.util.StringUtils;

import java.util.Objects;

/**
 * @author zequs
 * @version $Id: concurrent-demo, v0.1 2020 07 10 Exp $
 */
@Data
public class User {

    private String  name;
    private Integer age;

    public User() {
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof  User) {
            User u = (User) obj;
            if (!StringUtils.isEmpty(u.getName()) && !StringUtils.isEmpty(this.getName())) {
                if (this.getName().equals(u.getName())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
