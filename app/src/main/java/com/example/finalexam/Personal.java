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
    public  static  final String TAG="Personal";

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

    TextView tv1;
    TextView tv2;
    TextView tv3;
    TextView tv4;
    TextView tv5;

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

        name.setText("用户名:"+n);
        getInfo();
        initview();
    }
public  void initview(){
        tv1=findViewById(R.id.tv1);
        tv2=findViewById(R.id.tv2);
        tv3=findViewById(R.id.tv3);
        tv4=findViewById(R.id.tv4);
        tv5=findViewById(R.id.tv5);

        tv1.setOnClickListener(this);
        tv2.setOnClickListener(this);
        tv3.setOnClickListener(this);
        tv4.setOnClickListener(this);
        tv5.setOnClickListener(this);

}
    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.imageBtn){

        }
        if(view.getId()==R.id.edit){
            intent=new Intent(this,EditorPerson.class);
            startActivity(intent);
        }
        if(view.getId()==R.id.tv4){
            //修改密码页

        }
        if(view.getId()==R.id.tv1){
            //收藏页

        }
        if(view.getId()==R.id.tv2){
            //点赞页

        }
        if(view.getId()==R.id.tv3){
            //关注页

        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if(requestCode==1 && resultCode==2){
            Bundle bdl=data.getExtras();
             b=bdl.getString("birth");
             a=bdl.getString("age");
             s=bdl.getString("sex");
             g=bdl.getString("grade");
             i=bdl.getString("introduce");
           getInfo();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    public boolean getInfo(){
        SharedPreferences getShare=getSharedPreferences("person",Activity.MODE_PRIVATE);
        b=getShare.getString("birth","");
        a=getShare.getString("age","");
        s=getShare.getString("sex","");
        g=getShare.getString("grade","");
        i=getShare.getString("introduce","");

        birth.setText("出生日期 : "+b);
        age.setText("年龄 : "+a);
        sex.setText("性别 : "+s);
        grade.setText("年级 : "+g);
        introduce.setText("个性标签 : "+i);

        return  true;
    }
    protected void onResume() {
                super.onResume();
                getInfo();
    }
}
