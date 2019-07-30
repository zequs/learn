package com.zequs.demo.springbootjardemo.TestController;

import com.zequs.demo.springbootjardemo.demo.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zequs
 * @version $Id: springboot-jar-demo, v0.1 2019 07 18 Exp $
 */
@RestController
public class TestController {

    @Autowired
    private Config config;

    @GetMapping("/jar")
    public String test() {
        return "success";
    }

    @GetMapping("/zequs")
    public String zequs() {
        System.out.println("name: " + config.getName());
        System.out.println("prot: " + config.getPort());
        return "success";
    }
}
