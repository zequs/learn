package com.zequs.demo.se.designpattern.pattern.responsibility;

/**
 * 分院审批人
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 09 Exp $
 */
public class DepartmentApprover extends Approver {

    public DepartmentApprover(Approver approver, String name) {
        super(approver,name);
    }

    @Override
    public void processRequest(PurchaseRequest request) {
        if (request.getPrice() <= 1000) {
            System.out.println( "采购请求ID：" + request.getId() +  "已被" +  this.getName() + "批准");
        } else {
            this.approver.processRequest(request);
        }
    }
}
