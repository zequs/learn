package com.zequs.demo.springboot.demo.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Zequs {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Zequs(){

    }
    public Zequs(String name) {
        this.name = name;
    }

    @Bean("zequsa")
    public Zequs createZequs() {
        return new Zequs("zhangsan");
    }


}
