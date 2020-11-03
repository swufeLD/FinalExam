package com.example.finalexam;

public class BYPMessage {
    private int id;
    private String Name;
    private String StuId;
    private String Target;
    private String TargetMajor;
    private String Get;

    public BYPMessage() {
        super();
        Name="";
        StuId="";
        Target="";
        TargetMajor="";
        Get="";
    }
    public  BYPMessage(String name,String stuid ,String target,String targetMajor,String get) {
        super();
        this.Name=name;
        this.StuId=stuid;
        this.Target=target;
        this.TargetMajor=targetMajor;
        this.Get=get;
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
    public String getTarget(){
        return Target;
    }
    public void setTarget(String target){
        this.Target=target;
    }
    public String getTargetMajor(){
        return TargetMajor;
    }
    public void setTargetMajor(String targetMajor){
        this.TargetMajor=targetMajor;
    }
    public String getGet(){
        return Get;
    }
    public void setGet(String get){
        this.Get=get;
    }
}