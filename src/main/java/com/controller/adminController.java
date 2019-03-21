package com.controller;

import com.dao.getBook;
import com.dao.getReader;
import com.model.books;
import com.model.reader;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
public class adminController {

    //图书信息管理
    @RequestMapping("BookInfoManage")
    public String turnBookInfoManage(Map<String,Object> model) throws IOException {

        getBook FindBook = new getBook();
        List<books> booksList = FindBook.allBooks();
        model.put("booksList",booksList);
        return "BookInfoManage";
    }

    //读者信息管理
    @RequestMapping("ReaderInfoManage")
    public String turnReaderInfoManage(Map<String,Object> model) throws IOException {
        getReader readerInfo = new getReader();
        List<reader> readerList = readerInfo.getReaderInfo();
        model.put("readerList",readerList);
        return "ReaderInfoManage";
    }

    //读者信息删除
    @RequestMapping("/DelReader")
    public String DelReader(int id) throws IOException {
        getReader readerInfo = new getReader();
        readerInfo.delReader(id);
        return "redirect:/ReaderInfoManage";
    }

    //转向读者信息修改界面
    @RequestMapping("/turnReaderChangeView")
    public String turnReaderChangeView(int id,Model model) throws IOException {
        getReader getOne = new getReader();
        reader readerInfo = getOne.getOne(id);
        model.addAttribute("readerInfo",readerInfo);
        return "adminChangeReaedr";
    }
    //修改读者信息，提交至数据库
    @RequestMapping("/ChangeReaderInfo")
    public String changeReaderInfo(reader reader,int id,HttpServletRequest request,@RequestParam("photoFile")MultipartFile photoFile) throws IOException {
        if(!photoFile.isEmpty()){
            //写入图片并得到图片路径
            String photo = getPhotoPath(request,photoFile);
            reader.setPhoto(photo);
        }
        getReader update = new getReader();
        update.changeReaderInfo(reader);
        return "redirect:/ReaderInfoManage";
    }

    //DelBook
    @RequestMapping("/DelBook")
    public String DleBook(int id) throws IOException {

        getBook delete = new getBook();
        delete.delBook(id);
        return "redirect:/BookInfoManage";
    }

    //转向修改界面
    @RequestMapping("/turnChangeView")
    public String turnChangeView(int id,Model model) throws IOException {
        getBook findOne = new getBook();
        model.addAttribute("book",findOne.getOne(id));
        return "adminChangeBook";
    }

    //修改图书信息
    @RequestMapping("/ChangeInfo")
    public String ChangeInfo(books book,HttpServletRequest request,@RequestParam("photoFile")MultipartFile photoFile) throws IOException {

        if(!photoFile.isEmpty()){
            //写入图片并得到图片路径
            String photo = getPhotoPath(request,photoFile);
            book.setPhoto(photo);
        }
        getBook update = new getBook();
        update.changeBookInfo(book);
        return "redirect:/BookInfoManage";
    }

    //转向图书入库页面
    @RequestMapping("/turnAddView")
    public String turnAddView(){
        return "adminAddBook";
    }

    //增加图书信息
    @RequestMapping("/AddBook")
    public String AddBook(books b, HttpServletRequest request,@RequestParam("photoFile")MultipartFile photoFile) throws IOException {
        books book = b;
        String photo = getPhotoPath(request,photoFile);
        book.setPhoto(photo);
        getBook insert = new getBook();
        insert.addBook(book);
        return "redirect:/BookInfoManage";
    }

    //写入图片并得到图片路径
    public String getPhotoPath(HttpServletRequest request,@RequestParam("photoFile")MultipartFile photoFile) throws IOException {

        String dir = request.getSession().getServletContext().getRealPath("/resources/img/");
        // 原始的文件名
        String fileName = photoFile.getOriginalFilename();
        // 扩展名
        String extName = fileName.substring(fileName.lastIndexOf("."));
        // 防止文件名冲突
        fileName = System.nanoTime() + extName;
        // 写文件到 resources 目录
        FileUtils.writeByteArrayToFile(new File(dir + fileName), photoFile.getBytes());
        String photo = "/resources/img/" + fileName;
        return photo;
    }
}
