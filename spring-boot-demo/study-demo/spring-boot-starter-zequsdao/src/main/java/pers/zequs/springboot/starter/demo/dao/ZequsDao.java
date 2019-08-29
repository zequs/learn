package pers.zequs.springboot.starter.demo.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pers.zequs.springboot.starter.demo.properties.DBProperties;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zequs
 * @version $Id: starter, v0.1 2019 08 20 Exp $
 */
public class ZequsDao {

    @Autowired
    private DBProperties dbProperties;

    public <T> List<T>  sql(String sql, Class<T> clazz) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String url = dbProperties.getUrl();
        String user = dbProperties.getUserName();
        String password = dbProperties.getPassword();
        List<T> list = new ArrayList<>();
        try {
            Class.forName(dbProperties.getDriver()).newInstance();
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next() != false) {
                T obj = oneRowToObject(resultSet, clazz);
                list.add(obj);
                //这里可以执行一些其他的操作
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            release(connection, statement, resultSet);
        }
        return list;
    }


    public void release(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private <T> T oneRowToObject(ResultSet rs, Class<T> cls) throws InstantiationException, IllegalAccessException, SQLException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        T obj;
        obj = cls.newInstance();
        //获取结果集元数据(获取此 ResultSet 对象的列的编号、类型和属性。)
        ResultSetMetaData rd = rs.getMetaData();
        for (int i = 0; i < rd.getColumnCount(); i++) {
            //获取列名
            String columnName = rd.getColumnLabel(i + 1);
            //组合方法名
            String methodName = "set" + columnName.substring(0, 1).toUpperCase() + columnName.substring(1);
            while (methodName.contains("_")) {
                int a = methodName.indexOf("_");
                String b = methodName.substring(a+1, a + 2);
                methodName = methodName.substring(0, a) + b.toUpperCase() + methodName.substring(a + 2);
            }
            //获取列类型
            int columnType = rd.getColumnType(i + 1);
            Method method = null;
            switch (columnType) {
                case java.sql.Types.VARCHAR:
                case java.sql.Types.CHAR:
                    method = cls.getMethod(methodName, String.class);
                    if (method != null) {
                        method.invoke(obj, rs.getString(columnName));
                    }
                    break;
                case java.sql.Types.INTEGER:
                case java.sql.Types.SMALLINT:
                    method = cls.getMethod(methodName, Integer.class);
                    if (method != null) {
                        method.invoke(obj, rs.getInt(columnName));
                    }
                    break;
                case java.sql.Types.BIGINT:
                    method = cls.getMethod(methodName, long.class);
                    if (method != null) {
                        method.invoke(obj, rs.getLong(columnName));
                    }
                    break;
                case java.sql.Types.DATE:
                case java.sql.Types.TIMESTAMP:
                    try {
                        method = cls.getMethod(methodName, Date.class);
                        if (method != null) {
                            method.invoke(obj, rs.getTimestamp(columnName));
                        }
                    } catch (Exception e) {
                        method = cls.getMethod(methodName, String.class);
                        if (method != null) {
                            method.invoke(obj, rs.getString(columnName));
                        }
                    }
                    break;
                case java.sql.Types.DECIMAL:
                    method = cls.getMethod(methodName, BigDecimal.class);
                    if (method != null) {
                        method.invoke(obj, rs.getBigDecimal(columnName));
                    }
                    break;
                case java.sql.Types.DOUBLE:
                case java.sql.Types.NUMERIC:
                    method = cls.getMethod(methodName, double.class);
                    if (method != null) {
                        method.invoke(obj, rs.getDouble(columnName));
                    }
                    break;
                case java.sql.Types.BIT:
                    method = cls.getMethod(methodName, boolean.class);
                    if (method != null) {
                        method.invoke(obj, rs.getBoolean(columnName));
                    }
                    break;
                default:
                    break;
            }
        }
        return obj;
    }
}
