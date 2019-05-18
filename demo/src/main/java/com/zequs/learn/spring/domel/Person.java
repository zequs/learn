package com.zequs.learn.spring.domel;

import java.util.List;
import java.util.Map;

public class Person {
    private String Pname;//姓名
    private int age;//年龄
    private Car car;//一辆车
    private List<Car> cars;//很多车
    private Map<String, String> des;//描述
    
    public Person() {
        
    }
    
    public void setDes(Map<String, String> des) {
        this.des = des;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
    public void setPname(String pname) {
        Pname = pname;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setCar(Car car) {
        this.car = car;
    }
    @Override
    public String toString() {
        return "Person [Pname=" + Pname + ", age=" + age + ", car=" + car + ", cars=" + cars + ", des=" + des + "]";
    }
    
    
}