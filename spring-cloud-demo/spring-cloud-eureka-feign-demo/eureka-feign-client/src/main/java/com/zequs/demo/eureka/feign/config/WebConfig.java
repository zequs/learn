package com.zequs.demo.eureka.feign.config;

import com.zequs.demo.eureka.feign.interceptor.CrossInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author zequs
 * @version $Id: aicenter, v0.1 2019 05 21 Exp $
 */
//@Configuration
public class WebConfig extends WebMvcConfigurationSupport {


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);

        //添加拦截器
        registry.addInterceptor(new CrossInterceptor()).
                addPathPatterns("/**").excludePathPatterns("/user/login.do");
    }

}
