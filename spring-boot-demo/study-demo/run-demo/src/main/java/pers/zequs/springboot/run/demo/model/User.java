package pers.zequs.springboot.run.demo.model;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Integer id;
    private String name;
    private Integer age;
    private Date createTime;
    private Date updateTime;
}
