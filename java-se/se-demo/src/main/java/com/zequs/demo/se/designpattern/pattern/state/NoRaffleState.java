package com.zequs.demo.se.designpattern.pattern.state;

/**
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 09 Exp $
 */
public class NoRaffleState extends State {

    private Activity activity;

    public NoRaffleState(Activity activity) {
        this.activity = activity;
    }
    @Override
    public void deductMoney() {
        System.out.println("扣除50积分，你可以参与抽奖");
        activity.setState(activity.getCanRaffleState());
    }

    @Override
    public boolean raffle() {
        System.out.println("扣了积分才能抽奖");
        return  false;
    }

    @Override
    public void dispensePrize() {
        System.out.println("你还没中奖，不能发放奖品");
    }
}
