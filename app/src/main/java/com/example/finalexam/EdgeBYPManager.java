package com.example.finalexam;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class EdgeBYPManager {

    private EdgeBYPDBHelper dbHelper;
    private String usertable;

    String s;

    public EdgeBYPManager(Context context){
        dbHelper=new EdgeBYPDBHelper(context);
        usertable=EdgeBYPDBHelper.Edge_BYP;
    }
    public void add(EdgeBYP message ){
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
    public ArrayList<EdgeBYP> list(int size){
        ArrayList<EdgeBYP> list=new ArrayList<>(size);
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        Cursor cursor= db.query(usertable,null,null, null, null, null, "Date desc,Count desc");
        if(cursor!=null){
            int k=0;
            while(cursor.moveToNext() && k<size){
               EdgeBYP guaMessage=new EdgeBYP();
                guaMessage.setId(cursor.getInt(cursor.getColumnIndex("ID")));
                guaMessage.setAuthor(cursor.getString(cursor.getColumnIndex("Author")));
                guaMessage.setDate(cursor.getString(cursor.getColumnIndex("Date")));
                guaMessage.setTitle(cursor.getString(cursor.getColumnIndex("Title")));
                guaMessage.setContent(cursor.getString(cursor.getColumnIndex("Content")));
                guaMessage.setCount(cursor.getInt(cursor.getColumnIndex("Count")));
                guaMessage.setComment(cursor.getString(cursor.getColumnIndex("Comment")));

                list.add(guaMessage);
                k++;
            }
            cursor.close();
        }
        db.close();
        return list;
    }
    public void insertcomment(int id,String comment){
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        Cursor cursor=db.query(usertable,null,"ID=?",new String[]{String.valueOf(id)},null,null,null);
        if(cursor!=null && cursor.moveToFirst()){
            s= cursor.getString(cursor.getColumnIndex("Comment"));
        }
        s=s+"#"+comment;
        ContentValues values = new ContentValues();
        values.put("Comment",s);
        db.update(usertable,values,"ID=?", new String[]{String.valueOf(id)});
        db.close();
    }
}
