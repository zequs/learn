package com.zequs.demo.se.designpattern.pattern.responsibility;

/**
 * 审批人
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 09 Exp $
 */
public abstract class Approver {
    private  String name;
    Approver approver;

    public Approver(Approver approver, String name) {
        this.approver = approver;
        this.name = name;
    }

    public abstract void processRequest(PurchaseRequest request);

    public String getName() {
        return name;
    }
}
