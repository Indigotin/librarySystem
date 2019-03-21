package com.controller;

import com.dao.getAdmin;
import com.dao.getBook;
import com.dao.getReader;
import com.model.books;
import com.model.reader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
public class loginController {

    @RequestMapping("/loginView")
    public String turnLoginView(){
        return "login";
    }

    @RequestMapping("/login")// Model model,
    public String isAdmin(HttpServletRequest request,Map<String,Object> model) throws IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        System.out.println(email+","+password);
        //从admin和reader的表里查询匹配
        getAdmin admin = new getAdmin();
        getReader reader = new getReader();

        if(admin.isAdmin(email,password)){
            //将用户名存到session中
            request.getSession().setAttribute("email", email);
            getBook FindBook = new getBook();
            List<books> booksList = FindBook.allBooks();
            model.put("booksList",booksList);
            return "adminHomePage";
        }
        else if(reader.isReader(email,password)){
            request.getSession().setAttribute("email", email);
            System.out.println(email+","+password);
            return "redirect:/turnReaderHomePage";
        }
        else{
            /*model.addAttribute("href","/loginView");
            model.addAttribute("msg","账号或密码错误！");*/
            return "error";
        }
    }

    @RequestMapping("/turnReaderHomePage")
    public String turnReaderHomePage(){
        return "readerHomePage";
    }

    @RequestMapping("/turnEnrollView")
    public String turnEnroll(){
        return "enroll";
    }

    @RequestMapping("/newReader")
    public String newReader(reader reader,HttpServletRequest request) throws IOException {
        System.out.println("提交成功！");
        String password = request.getParameter("password");
        String cPassword = request.getParameter("cPassword");
        if(!password.equals(cPassword)){
            return "error";
        }
        else{
            System.out.println(reader);
            reader.setBorrowNum(2);
            getReader insert = new getReader();
            insert.insertInfo(reader);
        }
        return "redirect:/loginView";
    }
}
