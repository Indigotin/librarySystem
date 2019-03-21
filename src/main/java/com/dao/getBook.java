package com.dao;

import com.model.books;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

public class getBook {

    //暂时实现用书名查询
    public List<books> findBook(String bookname) throws IOException {
        SqlSession sqlSession = GetSqlSession.getSqlSession();
        books o = new books();
        o.setBookname(bookname);
        //com/mapper/booksMapper.findAll正确
        //com.mapper.booksMapper.findAll报错
        List<books> bookList = sqlSession.selectList("com/mapper/booksMapper.findAll",o);
        return bookList;
    }

    //管理员获得所有图书信息
    public List<books> allBooks() throws IOException {
        SqlSession sqlSession = GetSqlSession.getSqlSession();
        List<books> bookList = sqlSession.selectList("com/mapper/booksMapper.findAll");
        return bookList;
    }

    //管理员删除图书信息
    public void delBook(int id) throws IOException {
        SqlSession sqlSession = GetSqlSession.getSqlSession();
        books o = new books();
        o.setId(id);
        sqlSession.delete("com/mapper/booksMapper.deleteById",o);
        sqlSession.commit();
    }

    //管理员添加图书信息
    public void addBook(books book) throws IOException {
        SqlSession sqlSession = GetSqlSession.getSqlSession();
        sqlSession.insert("com/mapper/booksMapper.insert",book);
        //默认是不自动提交，必须手工提交(除了查询都不是自动提交
        sqlSession.commit();
    }

    //管理员获得某本图书信息
    public books getOne(int id) throws IOException {
        SqlSession sqlSession = GetSqlSession.getSqlSession();
        return sqlSession.selectOne("com/mapper/booksMapper.getOne",id);
    }

    //管理员管理图书信息
    public void changeBookInfo(books book) throws IOException {
        SqlSession sqlSession = GetSqlSession.getSqlSession();
        sqlSession.update("com/mapper/booksMapper.update",book);
        //默认是不自动提交，必须手工提交(除了查询都不是自动提交
        sqlSession.commit();
    }
}
