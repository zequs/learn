package com.zequs.mybatis.demo.jdbc;

import org.apache.ibatis.io.Resources;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author zequs
 * @version : mybatis-demo-test, v0.1 2020 10 29 Exp $
 */
public class JDBCTest {
    public static void main(String[] args) throws Exception{
        String resource = "mysql.properties";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        Properties properties = new Properties();
        properties.load(inputStream);
        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from blog");
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            System.out.println(id);
            String name = resultSet.getString("name");
            System.out.println(name);
        }
    }
}
