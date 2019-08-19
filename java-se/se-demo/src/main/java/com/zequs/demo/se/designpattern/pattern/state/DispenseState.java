package com.zequs.demo.se.designpattern.pattern.state;

import java.util.Random;

/**
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 09 Exp $
 */
public class DispenseState extends State {

    private Activity activity;

    public DispenseState(Activity activity) {
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
        return false;
    }

    @Override
    public void dispensePrize() {
        if(activity.getCount() > 0){
            System.out.println("恭喜中奖了");
            // 改变状态为不能抽奖
            activity.setState(activity.getNoRaffleState());
            activity.setCount(activity.getCount()-1);
        }else{
            System.out.println("很遗憾，奖品发送完了");
            // 改变状态为奖品发送完毕, 后面我们就不可以抽奖
            activity.setState(activity.getDispenseOutState());
            //System.out.println("抽奖活动结束");
            //System.exit(0);
        }
    }
}
