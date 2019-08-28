package pers.zequs.springboot.simple.iimport.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import pers.zequs.springboot.simple.iimport.demo.model.Person;
import pers.zequs.springboot.simple.iimport.demo.model.User;

/**
 * @author zequs
 * @version $Id: study-demo-parent, v0.1 2019 08 28 Exp $
 */
@Configuration
@Import(Person.class)
public class UserImportConfig {

    @Bean
    public User user() {
        return new User("user-zhangsan");
    }
}
