/**
 * Huihe.com Inc.
 * Copyright (c) 2016-2020 All Rights Reserved.
 */
package com.zequs.demo.eureka.feign.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Monitor拦截器
 *
 * @author xilu.tong
 * @version $Id: MonitorInterceptor.java, v0.1 2016年10月10日 下午5:38:37 xilu.tong Exp $
 */
public class MonitorInterceptor implements MethodInterceptor {

    private static final Logger monitorLog = LoggerFactory.getLogger("MONITOR-LOGGER");

    private static final String md5Key = "MKnEu6zaS04N23XoMUL8GOwOKIQwXMvT";

    private static final List<String> exclude = new ArrayList<>();

    private static final List<String> noLogClass = new ArrayList<>();

    static {
      /*  exclude.add("getLocate");
        exclude.add("doBiz");
        exclude.add("doUploadFileToServer");
        exclude.add("sendUserFirstEdjJoinNotify");
        exclude.add("download");
        exclude.add("userLogin");

        exclude.add("sendMailWithAttachment");*/

        noLogClass.add("MonitorController");
        noLogClass.add("DownloadController");
    }

    /**
     * @see org.aopalliance.intercept.MethodInterceptor#invoke(org.aopalliance.intercept.MethodInvocation)
     */
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        if (true) {
            HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder
                    .getRequestAttributes())).getRequest();
            String params = null;
            params = getRequestBody(request.getInputStream());
            if (params== null || params.length()==0) {
                params =  request.getParameter("name");
            }
            System.out.println("参数："+ params);
            return invocation.proceed();
        }
        return null;
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
            System.err.println("【业务处理】解析参数异常\n" + e );
        }

        return body.toString();
    }
}
