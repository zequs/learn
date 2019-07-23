package com.zequs.demo.springboot.rocketmq.provider.controller;

import com.aliyun.openservices.shade.com.alibaba.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.client.producer.MQProducer;
import org.apache.rocketmq.common.message.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zequs
 * @version $Id: springboot-rocketmq-demo, v0.1 2019 07 15 Exp $
 */
@RestController
public class TestController {
    @Resource(name = "producer")
    private MQProducer producer;

    @GetMapping("/zequs/test")
    public String test(String name) throws Exception {

        Message msg = new Message("TopicTest" /* Topic */,
                "TagA" /* Tag */,
                ("Hello RocketMQ " +
                        name).getBytes(RemotingHelper.DEFAULT_CHARSET) /* Message body */
        );
        producer.send(msg);

        return "success";
    }
}
