package com.zequs.learn.spring;

import com.zequs.learn.spring.domel.Person;
import com.zequs.learn.spring.domel.Person1;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class demo {
    public static void main(String args[]) {
        ApplicationContext cxt= new ClassPathXmlApplicationContext("applicationContext.xml");
        Person p=(Person) cxt.getBean("car1");
        System.out.println(p);

        Object object = null;
        Class o =  object.getClass();
        System.out.println(o);
    }
}
