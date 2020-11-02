package com.example.finalexam;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class GuanZhu_DBHelper  extends SQLiteOpenHelper {
    private  static final int version=1;
    private  static final String DB_NAME="GuanZhuDB.db";
    public   static final String  GuanZhu="guanzhu";

    public GuanZhu_DBHelper (@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

    }
    public GuanZhu_DBHelper(Context context){

        super(context,DB_NAME,null,version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+ GuanZhu +"(ID INTEGER PRIMARY KEY AUTOINCREMENT, AuthorName text, Date text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
