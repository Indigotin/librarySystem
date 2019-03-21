package com.model;

public class reader {
    private int id;
    private String email;
    private String password;
    private String name;
    private int age;
    private String phone;
    private String photo;
    private double balance;
    private int borrowNum;
    public reader(){}
    public reader(int id,String email,String password,String name,int age,String phone,String photo,double balance){
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.photo = photo;
        this.balance = balance;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return email;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return password;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return age;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
    public String getPhone(){
        return phone;
    }
    public void setPhoto(String photo){
        this.photo = photo;
    }
    public String getPhoto(){
        return photo;
    }
    public double getBalance(){
        return balance;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }
    public int getBorrowNum(){
        return borrowNum;
    }
    public void setBorrowNum(int borrowNum){
        this.borrowNum = borrowNum;
    }
    public String toString(){
        return "id = "+id+",email = "+email+",name = "+name+",age = "+age+
                ",phone = "+phone+",photo = "+photo+",balance = "+balance+",borrowNum = "+borrowNum;
    }
}
