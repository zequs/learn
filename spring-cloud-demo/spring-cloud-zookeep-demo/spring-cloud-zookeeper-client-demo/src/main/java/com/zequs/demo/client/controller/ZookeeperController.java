package com.zequs.demo.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ZookeeperController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/zookeeper")
    private List<String> getService() {
        return discoveryClient.getServices();
    }
}
