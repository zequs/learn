/**
 * Copyright 2009-2017 the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.zequs.mybatis.demo.typeHandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * mybatis类型处理器
 * @author Clinton Begin
 */
@MappedJdbcTypes(JdbcType.TIMESTAMP)
public class MyDateTypeHandler extends BaseTypeHandler<Date> {

    /**
     *
     * 设值的时候，如insert
     * @param ps
     * @param i
     * @param parameter
     * @param jdbcType
     * @throws SQLException
     */
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Date parameter, JdbcType jdbcType)
            throws SQLException {
        System.out.println("======1=====MyDateTypeHandler========1=====");
        ps.setString(i, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(parameter));
    }

    /**
     * select从数据拿数据封装成java时候
     * @param rs
     * @param columnName
     * @return
     * @throws SQLException
     */
    @Override
    public Date getNullableResult(ResultSet rs, String columnName)
            throws SQLException {
        System.out.println("======2=====MyDateTypeHandler========2=====");
        String time = rs.getString(columnName);
        if (time != null && !time.equals("")) {
            try {
                return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(time);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public Date getNullableResult(ResultSet rs, int columnIndex)
            throws SQLException {
        System.out.println("======3=====MyDateTypeHandler========3=====");
        String time = rs.getString(columnIndex);
        if (time != null && time.equals("")) {
            try {
                return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(time);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 存储过程
     * @param cs
     * @param columnIndex
     * @return
     * @throws SQLException
     */
    @Override
    public Date getNullableResult(CallableStatement cs, int columnIndex)
            throws SQLException {
        System.out.println("======4=====MyDateTypeHandler========4=====");
        String time = cs.getString(columnIndex);
        if (time != null && time.equals("")) {
            try {
                return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(time);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
