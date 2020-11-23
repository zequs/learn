package com.zequs.mybatis.demo.dao;

import com.zequs.mybatis.demo.model.Blog;

/**
 * @author zequs
 * @version : mybatis-demo-test, v0.1 2020 10 29 Exp $
 */
public interface BlogMapper {
    Blog selectBlog(int id);
}
