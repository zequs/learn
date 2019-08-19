package com.zequs.demo.se.designpattern.pattern.state;

import java.util.Random;

/**
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 09 Exp $
 */
public class CanRaffleState extends State {

    private Activity activity;

    public CanRaffleState(Activity activity) {
        this.activity = activity;
    }
    @Override
    public void deductMoney() {
        System.out.println("你已经扣过积分");
    }

    @Override
    public boolean raffle() {
        System.out.println("你可以正常抽奖");
        Random random = new Random();
        if (random.nextInt(10) == 0) {
            System.out.println("恭喜你中奖了");
            activity.setState(activity.getDispenseState());
        } else {
            activity.setState(activity.getNoRaffleState());
        }
        return true;
    }

    @Override
    public void dispensePrize() {
        System.out.println("你还没中奖，不能发放奖品");
    }
}
