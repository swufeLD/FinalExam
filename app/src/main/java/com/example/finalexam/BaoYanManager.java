package com.example.finalexam;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class BaoYanManager {

    private BaoYan_DBHelper dbHelper;
    private String usertable;

    public BaoYanManager(Context context){
        dbHelper=new BaoYan_DBHelper(context);
        usertable=BaoYan_DBHelper.BaoYan;
    }
    public ArrayList<BaoYanMessage> list(String college){
        ArrayList<BaoYanMessage> list=new ArrayList<>();
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        Cursor cursor= db.query(usertable,null,"College=?", new String[]{college}, null, null, "Grade desc,Major desc");
        if(cursor!=null){
            while(cursor.moveToNext()){
               BaoYanMessage baoYanMessage=new BaoYanMessage();
                baoYanMessage.setId(cursor.getInt(cursor.getColumnIndex("ID")));
                baoYanMessage.setName(cursor.getString(cursor.getColumnIndex("Name")));
                baoYanMessage.setStuId(cursor.getString(cursor.getColumnIndex("StuId")));
                baoYanMessage.setGrade(cursor.getString(cursor.getColumnIndex("Grade")));
                baoYanMessage.setCollege(cursor.getString(cursor.getColumnIndex("College")));
                baoYanMessage.setMajor(cursor.getString(cursor.getColumnIndex("Major")));
                list.add(baoYanMessage);
            }
            cursor.close();
        }
        db.close();
        return list;
    }
    public ArrayList<BaoYanMessage> list2(String grade){
        ArrayList<BaoYanMessage> list2=new ArrayList<>();
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        Cursor cursor= db.query(usertable,null,"Grade=?", new String[]{grade}, null, null, "College desc,Major desc");
        if(cursor!=null){
            while(cursor.moveToNext()){
                BaoYanMessage baoYanMessage=new BaoYanMessage();
                baoYanMessage.setId(cursor.getInt(cursor.getColumnIndex("ID")));
                baoYanMessage.setName(cursor.getString(cursor.getColumnIndex("Name")));
                baoYanMessage.setStuId(cursor.getString(cursor.getColumnIndex("StuId")));
                baoYanMessage.setGrade(cursor.getString(cursor.getColumnIndex("Grade")));
                baoYanMessage.setCollege(cursor.getString(cursor.getColumnIndex("College")));
                baoYanMessage.setMajor(cursor.getString(cursor.getColumnIndex("Major")));
                list2.add(baoYanMessage);
            }
            cursor.close();
        }
        db.close();
        return list2;
    }
    public ArrayList<BaoYanMessage> list3(String grade,String college){
        ArrayList<BaoYanMessage> list3=new ArrayList<>();
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        Cursor cursor= db.query(usertable,null,"Grade=? and College=?", new String[]{grade,college}, null, null, "Grade desc,College desc,Major desc");
        if(cursor!=null){
            while(cursor.moveToNext()){
                BaoYanMessage baoYanMessage=new BaoYanMessage();
                baoYanMessage.setId(cursor.getInt(cursor.getColumnIndex("ID")));
                baoYanMessage.setName(cursor.getString(cursor.getColumnIndex("Name")));
                baoYanMessage.setStuId(cursor.getString(cursor.getColumnIndex("StuId")));
                baoYanMessage.setGrade(cursor.getString(cursor.getColumnIndex("Grade")));
                baoYanMessage.setCollege(cursor.getString(cursor.getColumnIndex("College")));
                baoYanMessage.setMajor(cursor.getString(cursor.getColumnIndex("Major")));
                list3.add(baoYanMessage);
            }
            cursor.close();
        }
        db.close();
        return list3;
    }
}
