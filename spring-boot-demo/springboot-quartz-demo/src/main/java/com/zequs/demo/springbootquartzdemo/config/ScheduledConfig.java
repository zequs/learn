package com.zequs.demo.springbootquartzdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author zequs
 * @version $Id: springboot-quartz-demo, v0.1 2019 06 20 Exp $
 */
@Component
public class ScheduledConfig {

    @Scheduled(cron = "*/2 * * * * ?")
    public void scheduledMethod(){
        // 设置为两秒启动一次
        System.out.println("定时器被触发"+new Date());
    }
}
