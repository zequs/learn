package com.zequs.demo.eureka.feign;

import com.zequs.demo.eureka.feign.api.service.PersonService;
import com.zequs.demo.eureka.feign.api.service.UserService;
import com.zequs.demo.eureka.feign.interceptor.MonitorInterceptor;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(clients = {UserService.class, PersonService.class})
public class EurekaFeignClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaFeignClientApplication.class, args);
    }

    @Bean
    public MonitorInterceptor monitorInterceptor() {
        return new MonitorInterceptor();
    }

    @Bean
    public BeanNameAutoProxyCreator transactionAutoProxy() {
        BeanNameAutoProxyCreator transactionAutoProxy = new BeanNameAutoProxyCreator();
        transactionAutoProxy.setProxyTargetClass(true);
        transactionAutoProxy.setBeanNames("*Controller");
        transactionAutoProxy.setInterceptorNames("monitorInterceptor");
        return transactionAutoProxy;
    }
}
