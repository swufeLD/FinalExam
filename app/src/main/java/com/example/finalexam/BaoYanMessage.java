package com.example.finalexam;

import java.util.Map;

public class BaoYanMessage {
    private int id;
    private String Name;
    private String StuId;
    private String Grade;
    private String College;
    private String Major;

    public BaoYanMessage() {
        super();
        Name="";
        StuId="";
        Grade="";
        College="";
        Major="";
    }
    public  BaoYanMessage(String name,String stuid ,String grade,String college,String major) {
        super();
        this.Name=name;
        this.StuId=stuid;
        this.Grade=grade;
        this.College=college;
        this.Major=major;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getName(){
        return Name;
    }
    public void setName(String name){
        this.Name=name;
    }
    public String getStuId(){
        return StuId;
    }
    public void setStuId(String stuId){
        this.StuId=stuId;
    }
    public String getGrade(){
        return Grade;
    }
    public void setGrade(String grade){
        this.Grade=grade;
    }
    public String getCollege(){
        return College;
    }
    public void setCollege(String college){
        this.College=college;
    }
    public String getMajor(){
        return Major;
    }
    public void setMajor(String major){
        this.Major=major;
    }
}
