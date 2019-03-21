package com.model;

public class borrowbook {
    private int id;
    //借书人的email
    private String email;
    private int bookID;
    //true为已还
    private boolean returned;
    public borrowbook(){}
    public borrowbook(int id, String email, int bookID){
        this.id = id;
        this.email = email;
        this.bookID = bookID;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    public void setEmail(String emial){
        this.email = emial;
    }
    public String getEmail(){
        return email;
    }
    public void setBookID(int bookID){
        this.bookID = bookID;
    }
    public int getBookID(){
        return bookID;
    }
    public void setReturned(boolean returned){
        this.returned = returned;
    }
    public boolean getReturned(){
        return returned;
    }
    public String toString(){
        return "id = "+id+",email = "+email+",bookID = "+bookID+",returned = "+returned;
    }
}
