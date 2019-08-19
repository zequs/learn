package com.zequs.demo.se.designpattern.pattern.responsibility;

/**
 * 责任链模式
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 09 Exp $
 */
public class Client {

    public static void main(String[] args) {

        Approver masterApprover = new ViceSchoolMasterApprover(null, "张部长");
        Approver schoolApprover = new SchoolApprover(masterApprover, "李院长");
        Approver collegeApprover = new CollegeApprover(schoolApprover,"王分院长");
        Approver departmentApprover = new DepartmentApprover(collegeApprover,"孙组长");

        PurchaseRequest request = new PurchaseRequest(1,"教师楼改造","教师楼改造金额", 7000.0f);
        departmentApprover.processRequest(request);
    }
}
