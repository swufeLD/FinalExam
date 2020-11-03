package com.example.finalexam;

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
    public BYPMessage GetBYP(String stuid){
        BYPMessage bypMessage=new BYPMessage();
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        Cursor cursor= db.query(usertable,null,"Stud=?", new String[]{stuid}, null, null, null);
        if(cursor!=null&& cursor.moveToFirst()){
            bypMessage.setId(cursor.getInt(cursor.getColumnIndex("ID")));
            bypMessage.setName(cursor.getString(cursor.getColumnIndex("Name")));
            bypMessage.setStuId(cursor.getString(cursor.getColumnIndex("StuId")));
            bypMessage.setTarget(cursor.getString(cursor.getColumnIndex("Target")));
            bypMessage.setTargetMajor(cursor.getString(cursor.getColumnIndex("TargetMajor")));
            bypMessage.setGet(cursor.getString(cursor.getColumnIndex("Get")));
            bypMessage.setContact(cursor.getString(cursor.getColumnIndex("Contact")));
            cursor.close();
        }
        db.close();
        return bypMessage;
    }
}
