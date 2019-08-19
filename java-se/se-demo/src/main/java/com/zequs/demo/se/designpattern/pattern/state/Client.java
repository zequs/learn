package com.zequs.demo.se.designpattern.pattern.state;

/**
 * 状态模式
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 12 Exp $
 */
public class Client {
    public static void main(String[] args) {
        Activity activity = new Activity(1);
        for (int i = 0; i < 30; i++) {
            System.out.println("--------第" + (i + 1) + "次抽奖----------");
            // 参加抽奖，第一步点击扣除积分
            activity.debuctMoney();

            // 第二步抽奖
            activity.raffle();
        }
    }

}
