package com.example.finalexam;

import android.app.Activity;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Gua_EditorMessage extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

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

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.share);

        title=findViewById(R.id.editText);
        content=findViewById(R.id.editText2);
        btn=findViewById(R.id.gua_btn);
        rg=findViewById(R.id.rg);
        rb1=findViewById(R.id.radioButton3);
        rb2=findViewById(R.id.radioButton4);

    }
    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.radioButton3){
            flag=true;
        }else{
            flag=false;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if(flag){
            sharedPreferences=getSharedPreferences("login", Activity.MODE_PRIVATE);
            author=sharedPreferences.getString("username","");
        }else {
            author="匿名用户";
        }
        String t=title.getText().toString();
        String c=content.getText().toString();

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        date=df.format(new Date());
        int count=0;
        GuaMessage guaMessage=new GuaMessage(author,date,t,c,count,"");
        GuaManager guaManager=new GuaManager(this);
        guaManager.add(guaMessage);
    }
}
