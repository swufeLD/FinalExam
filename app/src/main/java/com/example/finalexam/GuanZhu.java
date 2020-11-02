package com.example.finalexam;

public class GuanZhu {
    private int id;
    private String AuthorName;
    private String Date;
    public GuanZhu(){
        super();
        AuthorName="";
        Date="";
    }

    public GuanZhu(String  AuthorName,String Date){
        super();
        this.AuthorName=AuthorName;
        this.Date=Date;
    }
    public String getAuthorName(){
        return AuthorName;
    }
    public void setAuthorName(String Authorname){
        this.AuthorName=Authorname;
    }
    public String getDate(){
        return Date;
    }
    public void setDate(String Date){
        this.Date=Date;
    }
}
