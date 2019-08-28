package pers.zequs.springboot.slim.demo.controller;

import com.google.common.collect.Lists;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zequs
 * @version $Id: study-demo-parent, v0.1 2019 08 27 Exp $
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public List<String> test() {
        List<String> list = Lists.newArrayList("a","b","c","d");
        return list;
    }
}
