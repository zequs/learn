package com.zequs.springboot.demo.model;

/**
 * @author zequs
 * @version : springboot-mvc-demo, v0.1 2020 09 30 Exp $
 */
public class User {
    private Integer id;
    private String  name;
    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
