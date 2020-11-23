/**
 * Huihe.com Inc.
 * Copyright (c) 2016-2020 All Rights Reserved.
 */
package com.zequs.mybatis.demo.util;


import java.lang.reflect.Field;

/**
 * Java反射工具
 * @author xilu.tong
 * @version $Id: ReflectUtil.java, v0.1 2016年11月7日 下午1:51:58 xilu.tong Exp $
 */
public class ReflectUtil {
    /**
     * 利用反射获取指定对象的指定属性
     * @param obj 目标对象
     * @param fieldName 目标属性
     * @return 目标属性的值
     * @throws IllegalAccessException 
     * @throws IllegalArgumentException 
     */
    public static Object getFieldValue(Object obj, String fieldName)
                                                                    throws IllegalArgumentException,
                                                                    IllegalAccessException {
        Object result = null;
        final Field field = ReflectUtil.getField(obj, fieldName);
        if (field != null) {
            field.setAccessible(true);
            result = field.get(obj);
        }
        return result;
    }

    /**
     * 利用反射给指定对象的指定属性赋值
     * @param obj 目标对象
     * @param fieldName 目标属性
     * @param fieldValue 目标值
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public static void setFieldValue(Object obj, String fieldName, Object fieldValue)
                                                                                     throws IllegalArgumentException,
                                                                                     IllegalAccessException {
        final Field field = ReflectUtil.getField(obj, fieldName);
        if (field != null) {
            field.setAccessible(true);
            field.set(obj, fieldValue);
        }
    }

    /**
     * 将驼峰式命名的字符串转换为下划线大写方式。如果转换前的驼峰式命名的字符串为空，则返回空字符串。</br>
     * 例如：helloWorld->HELLO_WORLD
     * @param modelField 转换前的驼峰式命名的字符串
     * @return 转换后下划线大写方式命名的字符串
     */
    public static String underscoreName(String modelField) {
        StringBuilder result = new StringBuilder();
        if (modelField != null && modelField.length() > 0) {
            // 将第一个字符处理成大写
            result.append(modelField.substring(0, 1).toUpperCase());
            // 循环处理其余字符
            for (int i = 1; i < modelField.length(); i++) {
                String s = modelField.substring(i, i + 1);
                // 在大写字母前添加下划线
                if (s.equals(s.toUpperCase()) && !Character.isDigit(s.charAt(0))) {
                    result.append("_");
                }
                // 其他字符直接转成大写
                result.append(s.toUpperCase());
            }
        }
        return result.toString();
    }

    /**
     * 将下划线大写方式命名的字符串转换为驼峰式。如果转换前的下划线大写方式命名的字符串为空，则返回空字符串。</br>
     * 例如：HELLO_WORLD->helloWorld
     * @param dbField 转换前的下划线大写方式命名的字符串
     * @return 转换后的驼峰式命名的字符串
     */
    public static String camelName(String dbField) {
        if (dbField == null || dbField.isEmpty()) {
            return "";
        }
        dbField = dbField.toUpperCase();
        StringBuilder result = new StringBuilder();
        // 快速检查
        if (!dbField.contains("_")) {
            // 不含下划线，仅将首字母小写
            return dbField.substring(0, 1).toLowerCase() + dbField.substring(1);
        }
        // 用下划线将原始字符串分割
        String camels[] = dbField.split("_");
        for (String camel : camels) {
            // 跳过原始字符串中开头、结尾的下换线或双重下划线
            if (camel.isEmpty()) {
                continue;
            }
            // 处理真正的驼峰片段
            if (result.length() == 0) {
                // 第一个驼峰片段，全部字母都小写
                result.append(camel.toLowerCase());
            } else {
                // 其他的驼峰片段，首字母大写
                result.append(camel.substring(0, 1).toUpperCase());
                result.append(camel.substring(1).toLowerCase());
            }
        }
        return result.toString();
    }

    /**
     * 利用反射获取指定对象里面的指定属性
     * 
     * @param obj 目标对象
     * @param fieldName 目标属性
     * @return 目标字段
     */
    private static Field getField(Object obj, String fieldName) {
        Field field = null;
        for (Class<?> clazz = obj.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {
            try {
                field = clazz.getDeclaredField(fieldName);
                break;
            } catch (NoSuchFieldException e) {
                // 这里不用做处理，子类没有该字段可能对应的父类有，都没有就返回null。
            }
        }
        return field;
    }
}
