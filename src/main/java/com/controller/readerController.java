package com.controller;

import com.dao.getBook;
import com.dao.getBorrowBook;
import com.dao.getReader;
import com.model.books;
import com.model.borrowbook;
import com.model.reader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class readerController {

    @RequestMapping("/showBorrowedBooks")
    public String turnBorrowedBooks(HttpServletRequest request,Map<String,Object> model) throws IOException {
        String email = (String) request.getSession().getAttribute("email");
        System.out.println(email);
        getBorrowBook getRecords = new getBorrowBook();
        //得到所有借阅的书籍ID
        List<borrowbook> recordList = getRecords.getRecord(email);
        //通过书籍ID获取书籍详情
        getBook getbook = new getBook();
        List<books> borrowedBookList = new ArrayList<books>();
        for(borrowbook o:recordList){
            borrowedBookList.add(getbook.getOne(o.getBookID()));
        }
        model.put("recordList",recordList);
        model.put("borrowedBookList",borrowedBookList);
        return "BorrowedBooksView";
    }

    @RequestMapping("/payForfeit")
    public String turnPayForfeit(){
        return "payForfeit";
    }

    @RequestMapping("/borrowBook")
    public String borrowBookAct(int id, HttpServletRequest request, Model model) throws IOException {
        //借书处理

        String email = (String) request.getSession().getAttribute("email");//获取前面登录的用户名
        System.out.println(id+", "+email);
        //得到与email 对应的账号
        getReader getreader = new getReader();
        reader readerInfo = getreader.getOneByEmail(email);
        //判断余额或可借数量
        if(readerInfo.getBorrowNum()<=0 || readerInfo.getBalance()<0){
            model.addAttribute("href","/readerHomePage");
            model.addAttribute("msg","余额或可借数量不足！");
            System.out.println("余额或可借数量不足！");
            return "error";
        }else{
            //读者可借余量减一
            readerInfo.setBorrowNum(readerInfo.getBorrowNum()-1);
            //传入数据库修改
            getreader.changeReaderInfo(readerInfo);
        }

        //得到与ID对应的书
        getBook Book = new getBook();
        books book = Book.getOne(id);

        if(book.getNum()-1<0){
            model.addAttribute("href","/readerHomePage");
            model.addAttribute("msg","书籍余量不足！");
            System.out.println("书籍余量不足！");
            return "error";
        }else{
            //书籍余量减一
            book.setNum(book.getNum()-1);
            Book.changeBookInfo(book);
            //记录加一
            borrowbook index = new borrowbook();
            index.setEmail(email);
            index.setBookID(id);
            getBorrowBook record = new getBorrowBook();
            record.insert(index);
        }
        //完成借书记录查询后定向到记录界面
        return "redirect:/turnReaderHomePage";
    }

    @RequestMapping("/returnBook")
    public String returnBook(int id) throws IOException {
        getBorrowBook update = new getBorrowBook();
        borrowbook index = update.getOneByID(id);
        index.setReturned(!index.getReturned());
        update.updateInfo(index);
        return "redirect:/turnReaderHomePage";
    }
}
