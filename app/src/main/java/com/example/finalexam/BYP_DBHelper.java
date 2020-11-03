package com.example.finalexam;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BYP_DBHelper extends SQLiteOpenHelper {
    private  static final int version=1;
    private  static final String DB_NAME="BYPDB.db";
    public   static final String BYP="byp";


    public BYP_DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

    }
    public BYP_DBHelper(Context context){

        super(context,DB_NAME,null,version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+ BYP +"(ID INTEGER PRIMARY KEY AUTOINCREMENT, Name  text , StuId text Unique,Score text,Sort text, Target text,TargetMajor text,Get text,Contact text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
