package com.controller;

import com.dao.getBook;
import com.model.books;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
public class booksController {

    //读者查询图书(模糊查询)
    @RequestMapping("/searchBook")
    public String searchBook(String search,Map<String,Object> model) throws IOException {

        getBook FindBook = new getBook();
        System.out.println(search);
        search = search.trim();
        List<books> booksList = FindBook.findBook(search);
        model.put("booksList",booksList);
        return "readerBooksResult";
    }
}
