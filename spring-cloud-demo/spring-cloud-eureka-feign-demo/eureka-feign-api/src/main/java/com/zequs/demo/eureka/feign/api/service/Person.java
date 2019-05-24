package com.zequs.demo.eureka.feign.api.service;

/**
 * @author zequs
 * @version $Id: eureka-feign-parent, v0.1 2019 05 24 Exp $
 */
public class Person {
    private Long id;
    private int age ;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
