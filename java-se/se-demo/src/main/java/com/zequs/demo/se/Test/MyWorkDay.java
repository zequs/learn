package com.zequs.demo.se.Test;

/**
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 14 Exp $
 */
public class MyWorkDay extends AbstractTemplate {

    @Override
    public void workDay() {
        super.workDay();
    }

   /* @Override
    public void haveLunch() {
//        System.out.println("三楼吃午饭");
    }*/
    @Override
    public void haveLunch(String time) {
        System.out.println("1点在三楼吃午饭");
    }

    public static void main(String[] args) {
        MyWorkDay myWorkDay = new MyWorkDay();
        myWorkDay.workDay();
    }
}
