package com.zequs.demo.se.designpattern.pattern.state;

/**
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 09 Exp $
 */
public class DispenseOutState extends State {

    private Activity activity;

    public DispenseOutState(Activity activity) {
        this.activity = activity;
    }
    @Override
    public void deductMoney() {
        System.out.println("奖品发送完了，请下次再参加");
    }

    @Override
    public boolean raffle() {
        System.out.println("奖品发送完了，请下次再参加");
        return false;
    }

    @Override
    public void dispensePrize() {
        System.out.println("奖品发送完了，请下次再参加");
    }
}
