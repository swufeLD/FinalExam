package com.example.finalexam;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class BYPManager {
    private BYP_DBHelper dbHelper;
    private String usertable;

    public BYPManager(Context context){
        dbHelper=new BYP_DBHelper(context);
        usertable=BYP_DBHelper.BYP;
    }
    public void add(BYPMessage message ){
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        ContentValues values =new ContentValues();

        values.put("Name",message.getName());
        values.put("StuId",message.getStuId());
        values.put("Score",message.getScore());
        values.put("Sort",message.getSort());
        values.put("Target",message.getTarget());
        values.put("TargetMajor",message.getTargetMajor());
        values.put("Contact",message.getContact());
        values.put("Get",message.getGet());

        db.insert(usertable,null,values);
        db.close();
    }
    public BYPMessage GetBYP(String stuid){
        BYPMessage bypMessage=new BYPMessage();
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        Cursor cursor= db.query(usertable,null,"StuId=?", new String[]{stuid}, null, null, null);
        if(cursor!=null&& cursor.moveToFirst()){
            bypMessage.setId(cursor.getInt(cursor.getColumnIndex("ID")));
            bypMessage.setName(cursor.getString(cursor.getColumnIndex("Name")));
            bypMessage.setStuId(cursor.getString(cursor.getColumnIndex("StuId")));
            bypMessage.setTarget(cursor.getString(cursor.getColumnIndex("Target")));
            bypMessage.setTargetMajor(cursor.getString(cursor.getColumnIndex("TargetMajor")));
            bypMessage.setGet(cursor.getString(cursor.getColumnIndex("Get")));
            bypMessage.setContact(cursor.getString(cursor.getColumnIndex("Contact")));
            bypMessage.setScore(cursor.getString(cursor.getColumnIndex("Score")));
            bypMessage.setSort(cursor.getString(cursor.getColumnIndex("Sort")));
            cursor.close();
        }
        db.close();
        return bypMessage;
    }
}
