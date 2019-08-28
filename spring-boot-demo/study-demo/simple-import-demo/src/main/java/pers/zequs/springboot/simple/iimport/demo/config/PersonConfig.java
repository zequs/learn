package pers.zequs.springboot.simple.iimport.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import pers.zequs.springboot.simple.iimport.demo.annotation.PersonType;
import pers.zequs.springboot.simple.iimport.demo.importselector.PassengerImportBeanDefinitionRegistrar;
import pers.zequs.springboot.simple.iimport.demo.importselector.StudentConfigurationSelector;
import pers.zequs.springboot.simple.iimport.demo.model.Person;
import pers.zequs.springboot.simple.iimport.demo.model.User;

/**
 * @author zequs
 * @version $Id: study-demo-parent, v0.1 2019 08 28 Exp $
 */
@Configuration
@Import(Person.class)
//@Import(PassengerImportBeanDefinitionRegistrar.class)
//@Import(StudentConfigurationSelector.class)
@PersonType("student")  //这个注解只是为了具有一定的业务逻辑
public class PersonConfig {

    @Bean
    public User user() {
        return new User("user-zhangsan");
    }
}
