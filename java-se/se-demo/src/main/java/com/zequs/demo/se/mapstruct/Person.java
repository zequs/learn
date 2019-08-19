package com.zequs.demo.se.mapstruct;

import lombok.Data;

import java.util.Date;

/**
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 15 Exp $
 */
@Data
public class Person {
    private Long id;
    private String name;
    private String email;
    private Date birthday;
    private User user;
}
