package com.example.finalexam;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Baoyan_Editor extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener  {
    public static final String TAG="Gua_EditorMessage";

    TextView title;
    TextView content;
    Button btn;
    RadioGroup rg;
    RadioButton rb1;
    RadioButton rb2;
    boolean flag;
    SharedPreferences sharedPreferences;

    String author;
    String date;
    String count;
    Intent intent;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.baoyan_editor);

        title=findViewById(R.id.editText);
        content=findViewById(R.id.editText2);
        btn=findViewById(R.id.gua_btn);
        rg=findViewById(R.id.rg);
        rb1=findViewById(R.id.radioButton3);
        rb2=findViewById(R.id.radioButton4);
        btn.setOnClickListener(this);
        rg.setOnCheckedChangeListener(this);

        intent=getIntent();
        count=intent.getStringExtra("index");
    }

    @Override
    public void onClick(View view) {
        if(flag){
            sharedPreferences=getSharedPreferences("login", Activity.MODE_PRIVATE);
            author=sharedPreferences.getString("username","");
        }else {
            author="匿名用户";
        }
        //加入数据库
        if(count.equals("1")){
            //加入edgeBYP数据库
            String t=title.getText().toString();
            String c=content.getText().toString();

            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            date=df.format(new Date());
            int count=0;
            EdgeBYP edgeBYP=new EdgeBYP(author,date,t,c,count,"");
            EdgeBYPManager edgeBYPManager=new EdgeBYPManager(this);
            edgeBYPManager.add(edgeBYP);
            Toast.makeText(this,"提交成功！",Toast.LENGTH_LONG).show();
        }
        if(count.equals("2")){

        }
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int id) {
        if(id ==R.id.radioButton4){
            flag=true;
        }
        if(id ==R.id.radioButton3){
            flag=false;
        }
    }
}
