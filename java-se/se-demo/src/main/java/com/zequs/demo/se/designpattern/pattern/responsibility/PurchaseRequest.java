package com.zequs.demo.se.designpattern.pattern.responsibility;

/**
 * 采购请求（需求对象）
 *
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 09 Exp $
 */
public class PurchaseRequest {
    private int id;
    private String descr;
    private float price;
    private String name;

    public PurchaseRequest(int id,  String name,String descr, float price) {
        this.id = id;
        this.descr = descr;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
