package com.example.finalexam;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Personal extends AppCompatActivity implements View.OnClickListener {

    ImageButton imagebtn;
    Button edit;
    TextView name;
    TextView birth;
    TextView age;
    TextView sex;
    TextView grade;
    TextView introduce;
    Intent intent;

    String n;
    String b;
    String a;
    String s;
    String g;
    String i;

    SharedPreferences share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.person);

        imagebtn=findViewById(R.id.imageBtn);
        edit=findViewById(R.id.edit);
        name=findViewById(R.id.nicheng);
        birth=findViewById(R.id.birth);
        age=findViewById(R.id.age);
        sex=findViewById(R.id.sex);
        grade=findViewById(R.id.grade);
        introduce=findViewById(R.id.introduce);

        imagebtn.setOnClickListener(this);
        edit.setOnClickListener(this);

        share=getSharedPreferences("login", Activity.MODE_PRIVATE);
        n=share.getString("username","");

        name.setText(n);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.imageBtn){

        }
        if(view.getId()==R.id.edit){
            intent=new Intent(this,EditorPerson.class);
            startActivity(intent);
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if(requestCode==1 && resultCode==2){
            Bundle bdl=data.getExtras();
             b=bdl.getString("birth");
             a=bdl.getString("age");
             s=bdl.getString("age");
             g=bdl.getString("grade");
             i=bdl.getString("introduce");

             birth.setText(b);
             age.setText(a);
             sex.setText(s);
             grade.setText(g);
             introduce.setText(i);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
