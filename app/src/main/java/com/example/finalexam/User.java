package com.example.finalexam;

public class User {
    private int id;
    private String UserName;
    private String UserEmail;
    private String UserPassword;

    public User(){
        super();
        UserEmail="";
        UserName="";
        UserPassword="";
    }

    public User(String  UserName,String UserEmail,String UserPassword){
        super();
        this.UserPassword=UserPassword;
        this.UserName=UserName;
        this.UserEmail=UserEmail;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getUserName(){
        return UserName;
    }
    public void setUserName(String UserName){
        this.UserName=UserName;
    }
    public String getUserEmail(){
        return UserEmail;
    }
    public void setUserEmail(String UserEmail){
        this.UserEmail=UserEmail;
    }
    public String getUserPassword(){
        return UserPassword;
    }
    public void setUserPassword(String UserPsd){
        this.UserPassword=UserPsd;
    }
}

