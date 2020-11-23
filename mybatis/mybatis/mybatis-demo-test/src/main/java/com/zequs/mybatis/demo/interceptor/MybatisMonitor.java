/**
 * Huihe.com Inc.
 * Copyright (c) 2016-2020 All Rights Reserved.
 */
package com.zequs.mybatis.demo.interceptor;

import com.zequs.mybatis.demo.util.ReflectUtil;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.ParameterMode;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.type.TypeHandlerRegistry;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Properties;

/**
 * DAL拦截器
 *
 * @author xilu.tong
 * @version $Id: MybatisMonitor.java, v0.1 2016年8月20日 下午6:44:49 xilu.tong Exp $
 */
@Intercepts({@Signature(method = "setParameters", type = ParameterHandler.class, args = {PreparedStatement.class})})
public class MybatisMonitor implements Interceptor {


    public static String getSql(DefaultParameterHandler handler, long time) {
        String sql = showSql(handler);
        StringBuilder str = new StringBuilder();
        str.append("PrepareSQL[ " + time + " ms]:\n - ");
        str.append(sql);
        str.append(System.getProperty("line.separator"));
        str.append("------------------------------------------------------------");
        return str.toString();
    }

    public static String showSql(DefaultParameterHandler handler) {
        String sql = "";
        try {
            BoundSql boundSql = (BoundSql) ReflectUtil.getFieldValue(handler, "boundSql");
            Object parameterObject = ReflectUtil.getFieldValue(handler, "parameterObject");
            Configuration configuration = (Configuration) ReflectUtil.getFieldValue(handler,
                    "configuration");
            TypeHandlerRegistry typeHandlerRegistry = (TypeHandlerRegistry) ReflectUtil
                    .getFieldValue(handler, "typeHandlerRegistry");
            //获取sql
            sql = boundSql.getSql().replaceAll("[\\s]+", " ");
            //mybatis获取值的方式。在DefaultParameterHandler类
            List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
            if (parameterMappings != null) {
                for (int i = 0; i < parameterMappings.size(); i++) {
                    ParameterMapping parameterMapping = parameterMappings.get(i);
                    if (parameterMapping.getMode() != ParameterMode.OUT) {
                        Object value;
                        String propertyName = parameterMapping.getProperty();
                        if (boundSql.hasAdditionalParameter(propertyName)) { // issue #448 ask first for additional params
                            value = boundSql.getAdditionalParameter(propertyName);
                        } else if (parameterObject == null) {
                            value = null;
                        } else if (typeHandlerRegistry.hasTypeHandler(parameterObject.getClass())) {
                            value = parameterObject;
                        } else {
                            MetaObject metaObject = configuration.newMetaObject(parameterObject);
                            value = metaObject.getValue(propertyName);
                        }
                        if (value != null && sql.contains("?")) {
                            sql = sql.replaceFirst("\\?", value.toString());
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("【mybatis-SQL日志打印错误】" + e);
        }
        return sql;
    }

    /**
     * @see Interceptor#intercept(Invocation)
     */
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        DefaultParameterHandler handler = (DefaultParameterHandler) invocation.getTarget();
        Object returnValue = null;
        long start = System.currentTimeMillis();
        returnValue = invocation.proceed();
        long end = System.currentTimeMillis();
        long time = (end - start);
        String sql = getSql(handler, time);
        System.out.println(sql);
        return returnValue;
    }

    /**
     * @see Interceptor#plugin(Object)
     */
    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    /**
     * @see Interceptor#setProperties(Properties)
     */
    @Override
    public void setProperties(Properties properties) {
    }

}
