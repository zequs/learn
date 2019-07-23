package com.zequs.demo.springboot.rocketmq.provider.config;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MQProducer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zequs
 * @version $Id: springboot-rocketmq-demo, v0.1 2019 07 15 Exp $
 */
@Configuration
public class Config {
    private DefaultMQProducer producer = null;

    @Bean(name = "producer",destroyMethod="shutdown" )
    public MQProducer producer() throws Exception{
        producer = new
                DefaultMQProducer("please_rename_unique_group_name");
        // Specify name server addresses.
        producer.setNamesrvAddr("localhost:9876");
        //Launch the instance.
        producer.start();

        return producer;
    }

}
