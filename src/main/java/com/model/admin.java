package com.model;

public class admin {
    private int id;
    private String email;
    private String password;
    private String name;
    private int age;
    private String phone;
    private String photo;
    public admin(){}
    public admin(int id,String email,String password,String name,int age,String phone,String photo){
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.photo = photo;
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
    @Override
    public String toString(){
        return "id="+id+",Email="+email+",password="+password+",name="+name+"age="+age
                +",phone="+phone+",photo="+photo;
    }
}
