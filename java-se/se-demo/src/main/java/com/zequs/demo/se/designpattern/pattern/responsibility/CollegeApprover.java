package com.zequs.demo.se.designpattern.pattern.responsibility;

/**
 * 学院审批人
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 09 Exp $
 */
public class CollegeApprover extends Approver {

    public CollegeApprover(Approver approver, String name) {
        super(approver, name);
    }

    @Override
    public void processRequest(PurchaseRequest request) {
        if (request.getPrice() <= 5000 && request.getPrice() > 1000) {
            System.out.println( "采购请求ID：" + request.getId() +  "已被" +  this.getName() + "批准");
        } else {
            this.approver.processRequest(request);
        }
    }
}
