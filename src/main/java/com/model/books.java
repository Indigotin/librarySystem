package com.model;

public class books {
    private int id;
    private String bookname;
    private String author;
    private String press;
    private int price;
    private String introduce;
    private String photo;
    private int num;
    public books(){}
    public books(int id, String bookname, int num, String author, String press, int price, String introduce, String photo){
        this.id = id;
        this.bookname = bookname;
        this.num = num;
        this.author = author;
        this.press = press;
        this.price = price;
        this.introduce = introduce;
        this.photo = photo;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    public void setBookname(String bookname){
        this.bookname = bookname;
    }
    public String getBookname(){
        return bookname;
    }
    public void setAuthor(String author){
        this.author = author;
    }
    public String getAuthor(){
        return author;
    }
    public void setPress(String press){
        this.press = press;
    }
    public String getPress(){
        return press;
    }
    public void setPrice(int price){
        this.price = price;
    }
    public int getPrice(){
        return price;
    }
    public void setIntroduce(String introduce){
        this.introduce = introduce;
    }
    public String getIntroduce(){
        return introduce;
    }
    public void setPhoto(String photo){
        this.photo = photo;
    }
    public String getPhoto(){
        return photo;
    }
    public int getNum(){
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }
    @Override
    public String toString(){
        return "id="+id+",bookname="+bookname+",author="+author+",press="+press+"price="+price
                +",introduce="+introduce+",photo="+photo+",num = "+num;
    }
}
