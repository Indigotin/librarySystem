package com.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class GetSqlSession {
    public static SqlSession getSqlSession() throws IOException {
        /**
         *  1、获得 SqlSessionFactory
         *  2、获得 SqlSession
         *  3、调用在 mapper 文件中配置的 SQL 语句
         **/
        // 定位核心配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //创建 SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取到 SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession;
    }
}
