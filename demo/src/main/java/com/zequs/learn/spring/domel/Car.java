package com.zequs.learn.spring.domel;

public class Car {
    private String cname;//车名字
    private int price;//价格
    private double max;//最大速度
    
    
    public Car() {
        super();
        // TODO Auto-generated constructor stub
    }
    public Car(String cname, double max) {
        super();
        this.cname = cname;
        this.max = max;
    }
    public Car(String cname, int price) {
        super();
        this.cname = cname;
        this.price = price;
    }
    public void setCname(String cname) {
        this.cname = cname;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return "Car [cname=" + cname + ", price=" + price + ", max=" + max + "]";
    }
    
    
}