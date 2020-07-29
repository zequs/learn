package com.zequs.demo.model;

import java.util.Objects;

/**
 * @author zequs
 * @version : concurrent-demo, v0.1 2020 07 17 Exp $
 */
public class Person {
    private String  name;
    private Integer age;

    public Person() {
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name)
        //                &&Objects.equals(age, person.age);
        ;
    }
}
