package com.example.finalexam;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BaoYan_DBHelper extends SQLiteOpenHelper {
    private  static final int version=1;
    private  static final String DB_NAME="BaoYanDB.db";
    public   static final String BaoYan="baoyan";


    public BaoYan_DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

    }
    public BaoYan_DBHelper(Context context){

        super(context,DB_NAME,null,version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+ BaoYan +"(ID INTEGER PRIMARY KEY AUTOINCREMENT, Name  text Unique, StuId text, College text, Major text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
