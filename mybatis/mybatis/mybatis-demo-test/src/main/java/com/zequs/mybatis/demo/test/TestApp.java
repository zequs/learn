package com.zequs.mybatis.demo.test;

import com.zequs.mybatis.demo.dao.BlogMapper;
import com.zequs.mybatis.demo.model.Blog;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.Properties;

/**
 * @author zequs
 * @version : mybatis-demo-test, v0.1 2020 10 29 Exp $
 */
public class TestApp {

    public static void main(String[] args) throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //也可以配在mybatis-config.xml中
        Properties properties = new Properties();
        properties.load(Resources.getResourceAsStream("mysql.properties"));
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, properties);
        SqlSession session = sqlSessionFactory.openSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);
        Blog blog = mapper.selectBlog(1);
        System.out.println(blog);

    }
}
