package com.example.finalexam;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class ShouCangManager {
    private ShouCang_DBHelper dbHelper;
    private String usertable;

    public ShouCangManager(Context context){
        dbHelper=new ShouCang_DBHelper(context);
        usertable=ShouCang_DBHelper.ShouCang;
    }
    public void add(ShowCang message ){
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        ContentValues values =new ContentValues();

        values.put("Author",message.getAuthor());
        values.put("Date",message.getDate());
        values.put("Title",message.getTitle());
        values.put("Content",message.getContent());

        db.insert(usertable,null,values);
        db.close();
    }
}
