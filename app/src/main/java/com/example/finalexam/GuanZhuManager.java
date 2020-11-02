package com.example.finalexam;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class GuanZhuManager {
    private GuanZhu_DBHelper dbHelper;
    private String usertable;

    public GuanZhuManager(Context context){
        dbHelper=new GuanZhu_DBHelper(context);
        usertable=GuanZhu_DBHelper.GuanZhu;
    }
    public void add(GuanZhu message ){
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        ContentValues values =new ContentValues();

        values.put("AuthorName",message.getAuthorName());
        values.put("Date",message.getDate());

        db.insert(usertable,null,values);
        db.close();
    }
}
