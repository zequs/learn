package com.zequs.demo.springbootjardemo.TestController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zequs
 * @version $Id: springboot-jar-demo, v0.1 2019 07 18 Exp $
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public String test() {
        return "success";
    }
}
