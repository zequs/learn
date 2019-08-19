package com.zequs.demo.se.designpattern.pattern.responsibility;

/**
 * 学校审批人
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 09 Exp $
 */
public class SchoolApprover extends Approver {

    public SchoolApprover(Approver approver, String name) {
        super(approver, name);
    }

    @Override
    public void processRequest(PurchaseRequest request) {
        if (request.getPrice() <= 10000 && request.getPrice() > 5000) {
            System.out.println( "采购请求ID：" + request.getId() +  ",已被" +  this.getName() + "批准");
        } else {
            this.approver.processRequest(request);
        }
    }
}
