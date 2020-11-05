package com.example.finalexam;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

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
    public List<ShowCang> listAll(){
        List<ShowCang> rateList = null;
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(usertable, null, null, null, null, null, null);
        if(cursor!=null){
            rateList = new ArrayList<ShowCang>();
            while(cursor.moveToNext()){
                ShowCang item = new ShowCang();
                item.setId(cursor.getInt(cursor.getColumnIndex("ID")));
                item.setAuthor(cursor.getString(cursor.getColumnIndex("Author")));
                item.setDate(cursor.getString(cursor.getColumnIndex("Date")));
                item.setTitle(cursor.getString(cursor.getColumnIndex("Title")));
                item.setContent(cursor.getString(cursor.getColumnIndex("Content")));

                rateList.add(item);
            }
            cursor.close();
        }
        db.close();
        return rateList;
    }
}
