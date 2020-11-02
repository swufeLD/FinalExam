package com.example.finalexam;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ShouCang_DBHelper extends SQLiteOpenHelper {
    private  static final int version=1;
    private  static final String DB_NAME="ShouCangDB.db";
    public  static final String ShouCang="shoucang";

    public ShouCang_DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

    }
    public ShouCang_DBHelper(Context context){

        super(context,DB_NAME,null,version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+ ShouCang +"(ID INTEGER PRIMARY KEY AUTOINCREMENT, Author text, Date text, Title text, Content text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
