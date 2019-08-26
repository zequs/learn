package com.zequs.demo.springboot.demo.model;

/**
 * @author zequs
 * @version $Id: spring-boot-demo, v0.1 2019 08 22 Exp $
 */
public class User {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
