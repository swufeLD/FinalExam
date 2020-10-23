package com.example.finalexam;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

public class UserManager {
    private DBHelper dbHelper;
    private String usertable;

    public UserManager(Context context){
        dbHelper=new DBHelper(context);
        usertable=DBHelper.User;
    }
    public void add(User user ){
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        ContentValues values =new ContentValues();
        values.put("UserName",user.getUserName());
        values.put("UserEmail",user.getUserEmail());
        values.put("UserPassword",user.getUserPassword());

        db.insert(usertable,null,values);
        db.close();
    }
    public boolean findByName(String username){
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        Cursor cursor=db.query(usertable,null,
                "UserName=?",new String[]{username},null,null,null);
        // String flag=cursor.getString(cursor.getColumnIndex("UserName"));
        if(cursor!=null && cursor.moveToFirst()){
            return true;
        } else{
             return false;
         }
    }
    public String findPsw(String username){
        String psw=null;
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        Cursor cursor=db.query(usertable,null,
                "UserName=?",new String[]{username},null,null,null);
        if(cursor!=null && cursor.moveToFirst()){

            psw=cursor.getString(cursor.getColumnIndex("UserPassword"));
        }
        return psw;
    }

}
