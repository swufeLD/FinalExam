package com.example.finalexam;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    private  static final int version=1;
    private  static final String DB_NAME="FinalExam.db";
    public   static final String User="User";

    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

    }
    public DBHelper(Context context){

        super(context,DB_NAME,null,version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+User+"(ID INTEGER PRIMARY KEY AUTOINCREMENT, UserName  text Unique,UserEmail text,UserPassword text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
