package com.zequs.mybatis.demo.model;

import lombok.Data;

import java.util.Date;

/**
 * @author zequs
 * @version : mybatis-demo-test, v0.1 2020 10 29 Exp $
 */
@Data
public class Blog {
    private Integer id;
    private String name;
    private Date createTime;
    private Date updateTime;
}
