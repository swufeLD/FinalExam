package com.example.finalexam;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class GuaManager {

    private DBHelper dbHelper;
    private String usertable;

    public GuaManager(Context context){
        dbHelper=new DBHelper(context);
        usertable=DBHelper.Gua_EditorMessage;
    }
    public void add(GuaMessage message ){
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        ContentValues values =new ContentValues();
        values.put("Author",message.getAuthor());
        values.put("Date",message.getDate());
        values.put("Title",message.getTitle());
        values.put("Content",message.getContent());
        values.put("Count",message.getCount());
        values.put("Comment",message.getComment());

        db.insert(usertable,null,values);
        db.close();
    }
}
