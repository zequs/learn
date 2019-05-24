/**
 * Huihe.com Inc.
 * Copyright (c) 2017-2020 All Rights Reserved.
 */
package com.zequs.demo.eureka.feign.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 跨域拦截器
 * @author xilu.tong
 * @version $Id: CrossInterceptor.java, v0.1 2017年9月5日 下午4:30:31 xilu.tong Exp $
 */
public class CrossInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8090");
        response.setHeader("Access-Control-Allow-Credentials", "true");

        String params = null;
        String methodType = request.getMethod().toUpperCase();
        if (methodType.equals("POST")) {
            params = getRequestBody(request.getInputStream());
        } else {
            params = request.getParameter("jsonReq");
        }
        System.out.println("【业务处理】开始 - Param:[" + params + "]");
        return true;
    }

    private String getRequestBody(InputStream stream) {
        String line = "";
        StringBuilder body = new StringBuilder();
        int counter = 0;

        // 读取POST提交的数据内容  
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        try {
            while ((line = reader.readLine()) != null) {
                if (counter > 0) {
                    body.append("rn");
                }
                body.append(line);
                counter++;
            }
        } catch (IOException e) {
            System.out.println("【业务处理】解析参数异常\n"+ e );
        }

        return body.toString();
    }
}
