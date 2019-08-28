package pers.zequs.springboot.simple.enable.demo.model;

import lombok.Data;

/**
 * @author zequs
 * @version $Id: study-demo-parent, v0.1 2019 08 28 Exp $
 */
@Data
public class User {

    private String  name;
    private Integer age;
    private String  used;

    public User() {
    };

    public User(String name) {
        this.name = name;
    }
}
