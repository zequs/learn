package com.zequs.demo.dubbo.server.api.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zequs
 * @version $Id: springboot-dubbo-demo, v0.1 2019 07 05 Exp $
 */

@Data
public class User implements Serializable {
    private Integer id;
    private String name;
    private Integer age;
}
