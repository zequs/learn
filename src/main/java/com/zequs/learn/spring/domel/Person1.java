package com.zequs.learn.spring.domel;

import java.util.List;

public class Person1 {
    private String pname;
    private int age;
    private List<Car> cars;
    public void setPname(String pname) {
        this.pname = pname;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
    @Override
    public String toString() {
        return "Person1 [pname=" + pname + ", age=" + age + ", list=" + cars + "]";
    }
    
}