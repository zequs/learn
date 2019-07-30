package com.zequs.demo.springbootjardemo.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author zequs
 * @version $Id: springboot-jar-demo, v0.1 2019 07 26 Exp $
 */
//@ConfigurationProperties(prefix="zequs")
public class Config {

    private int port;

    private String name;

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
