package com.zequs.demo.se.Test;

/**
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 14 Exp $
 */
public abstract class AbstractTemplate {

    public void  workDay() {
        punch();
        work();
        haveLunch();
        lunchBreak();
        work();
        offWork();
        punch();
    }

    public  void punch() {
        System.out.println("打卡");
    }

    public  void work() {
        System.out.println("拼命工作");
    }
    public void haveLunch(){
       haveLunch(null);
    }
    public  void lunchBreak() {
        System.out.println("午休");
    }
    public  void offWork() {
        System.out.println("下班");
    }

    public void haveLunch(String time){
        if (time != null && !time.equals("")) {
            System.out.println("中午"+ time + "吃午饭");
        } else {
            System.out.println("吃午饭");
        }
    }
}
