package com.example.finalexam;

public class ShowCang {
    private int id;
    private String Author;
    private String Date;
    private String Title;
    private String Content;
    public ShowCang() {
        super();
        Author="";
        Date="";
        Title="";
        Content="";
    }
    public  ShowCang(String author,String date,String title,String content) {
        super();
        this.Author=author;
        this.Date=date;
        this.Title=title;
        this.Content=content;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getAuthor(){
        return Author;
    }
    public void setAuthor(String author){
        this.Author=author;
    }
    public String getDate(){
        return Date;
    }
    public void setDate(String date){
        this.Date=date;
    }
    public String getTitle(){
        return Title;
    }
    public void setTitle(String title){
        this.Title=title;
    }
    public String getContent(){
        return Content;
    }
    public void setContent(String content){
        this.Content=content;
    }

}
