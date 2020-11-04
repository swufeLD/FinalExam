package com.example.finalexam;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Welcom_Index extends AppCompatActivity implements View.OnClickListener {

    Button btn1;
    SharedPreferences share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_index);
        btn1=findViewById(R.id.btn1);
        btn1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        share=getSharedPreferences("login", Activity.MODE_PRIVATE);
        String name=share.getString("username","");
        if(name!=null){
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }else{
            Intent intent = new Intent(this,Login.class);
            startActivity(intent);
            Toast.makeText(this,"你还没有登陆，快去登陆吧！",Toast.LENGTH_LONG).show();
        }
    }
}
