package com.example.finalexam;

public class EdgeBYP {
    private int id;
    private String Author;
    private String Date;
    private String Title;
    private String Content;
    private int Count;
    private String Comment;

    public EdgeBYP() {
        super();
        Author="";
        Date="";
        Title="";
        Content="";
        Count=0;
        Comment="";
    }
    public  EdgeBYP(String author,String date,String title,String content,int count,String comment) {
        super();
        this.Author=author;
        this.Date=date;
        this.Title=title;
        this.Content=content;
        this.Count=count;
        this.Comment=comment;
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
    public int getCount(){
        return Count;
    }
    public void setCount(int count){
        this.Count=count;
    }
    public String getComment(){
        return Comment;
    }
    public void setComment(String comment){
        this.Comment=comment;
    }
}
