package com.dao;

import com.model.borrowbook;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

public class getBorrowBook {
    //插入借书记录
    public void insert(borrowbook index) throws IOException {
        SqlSession sqlSession = GetSqlSession.getSqlSession();
        sqlSession.insert("com/mapper/borrowbookMapper.insert",index);
        //默认是不自动提交，必须手工提交(除了查询都不是自动提交
        sqlSession.commit();
    }
    //通过用户email查询此账户借阅的所有图书
    public List<borrowbook> getRecord(String email) throws IOException {
        borrowbook o = new borrowbook();
        o.setEmail(email);
        SqlSession sqlSession = GetSqlSession.getSqlSession();
        List<borrowbook> list = sqlSession.selectList("com/mapper/borrowbookMapper.findAll",o);
        return list;
    }
    //通过id得到单条记录
    public borrowbook getOneByID(int id) throws IOException {
        SqlSession sqlSession = GetSqlSession.getSqlSession();
        return sqlSession.selectOne("com/mapper/borrowbookMapper.getOne",id);
    }
    //更新记录
    public void updateInfo(borrowbook index) throws IOException {
        SqlSession sqlSession = GetSqlSession.getSqlSession();
        sqlSession.update("com/mapper/borrowbookMapper.update",index);
        sqlSession.commit();
    }
}
