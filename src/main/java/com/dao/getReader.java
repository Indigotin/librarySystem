package com.dao;

import com.model.reader;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

public class getReader {
    //密码账号验证
    public boolean isReader(String email,String password) throws IOException {
        SqlSession sqlSession = GetSqlSession.getSqlSession();

        // 调用 mapper 中的方法：命名空间 + id
        List<reader> readerList = sqlSession.selectList("com/mapper/readerMapper.findAll");
        for(reader o:readerList){
            if(o.getEmail().equals(email)&&o.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

    //获取所有读者信息
    public List<reader> getReaderInfo() throws IOException {
        SqlSession sqlSession = GetSqlSession.getSqlSession();
        List<reader> readerList = sqlSession.selectList("com/mapper/readerMapper.findAll");
        return readerList;
    }

    //删除读者信息
    public void delReader(int id) throws IOException {
        SqlSession sqlSession = GetSqlSession.getSqlSession();
        sqlSession.delete("com/mapper/readerMapper.delete",id);
        sqlSession.commit();
    }
    //获取某一读者信息
    public reader getOne(int id) throws IOException {
        SqlSession sqlSession = GetSqlSession.getSqlSession();
        reader readerInfo = sqlSession.selectOne("com/mapper/readerMapper.findAll",id);
        return readerInfo;
    }
    //修改读者信息
    public void changeReaderInfo(reader reader) throws IOException {
        SqlSession sqlSession = GetSqlSession.getSqlSession();
        sqlSession.update("com/mapper/readerMapper.update",reader);
        sqlSession.commit();
    }
    //通过email得到账户
    public reader getOneByEmail(String email) throws IOException {
        SqlSession sqlSession = GetSqlSession.getSqlSession();
        reader result= sqlSession.selectOne("com/mapper/readerMapper.getByEmail",email);
        return result;
    }
    //注册
    public void insertInfo(reader reader) throws IOException {
        SqlSession sqlSession = GetSqlSession.getSqlSession();
        sqlSession.insert("com/mapper/readerMapper.insert",reader);
        sqlSession.commit();
    }
}
