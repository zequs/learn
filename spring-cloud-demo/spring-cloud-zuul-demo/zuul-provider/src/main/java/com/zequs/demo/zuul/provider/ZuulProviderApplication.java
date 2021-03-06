package com.zequs.demo.zuul.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * {@PersonService} 提供者应用
 *
 * @author 小马哥 QQ 1191971402
 * @copyright 咕泡学院出品
 * @since 2017/11/5
 */
@SpringBootApplication
//@EnableEurekaClient
public class ZuulProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulProviderApplication.class,args);
    }

}
