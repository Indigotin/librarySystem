package com.dao;

import com.model.admin;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

public class getAdmin {

    public boolean isAdmin(String email,String password) throws IOException {
        SqlSession sqlSession = GetSqlSession.getSqlSession();

        // 调用 mapper 中的方法：命名空间 + id
        List<admin> adminList = sqlSession.selectList("com/mapper/adminMapper.findAll");
        for(admin o:adminList){
            if(o.getEmail().equals(email)&&o.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
}
