package com.example.finalexam;

public class GuaMessage {
    private int id;
    private String author;
    private String date;
    private String title;
    private String content;
    private int count;
    private String comment;

    public GuaMessage() {
        super();
        author="";
        date="";
        title="";
        comment="";
        content="";
        count=0;
    }
    public  GuaMessage(String author,String date,String title,String content,int count,String comment) {
        super();
        this.author=author;
        this.date=date;
        this.title=title;
        this.content=content;
        this.count=count;
        this.comment=comment;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getAuthor(){
        return author;
    }
    public void setAuthor(String author){
        this.author=author;
    }
    public String getDate(){
        return date;
    }
    public void setDate(String date){
        this.date=date;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title=title;
    }
    public String getContent(){
        return content;
    }
    public void setContent(String content){
        this.content=content;
    }
    public String getComment(){
        return comment;
    }
    public void setComment(String comment){
        this.comment=comment;
    }
    public int getCount(){
        return count;
    }
    public void setCount(int count){
        this.count=count;
    }
}
