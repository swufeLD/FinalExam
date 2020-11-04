package com.example.finalexam;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ShowBYP extends AppCompatActivity {
    public static  final String TAG="ShowBYP";
    TextView bname;
    TextView bgrade;
    TextView bcollege;
    TextView bmajor;
    TextView bscore;
    TextView bsort;
    TextView bcontact;
    TextView tcollege;
    TextView tmajor;
    TextView show;

    String name;
    String grade;
    String college;
    String major;
    String score;
    String sort;
    String tbcollege;
    String tbmajor;
    String tbshow;
    String contact;

    Intent intent;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_byp);
        initViews();
        setPage();
    }
    public  void  initViews(){
        bname=findViewById(R.id.bname);
        bgrade=findViewById(R.id.bgrade);
        bcollege=findViewById(R.id.bcollege);
        bmajor=findViewById(R.id.bmajor);
        bscore=findViewById(R.id.bscore);
        bsort=findViewById(R.id.bsort);
        bcontact=findViewById(R.id.bcontact);
        bcollege=findViewById(R.id.bcollege);
        tcollege=findViewById(R.id.tcollege);
        tmajor=findViewById(R.id.tmajor);
        show=findViewById(R.id.bgrade);
    }
    public  void  setPage(){
        intent=getIntent();
        name=intent.getStringExtra("name");
        grade=intent.getStringExtra("grade");
        Log.i(TAG, "setPage: "+grade);
        major=intent.getStringExtra("major");
        Log.i(TAG, "setPage: "+major);
        college=intent.getStringExtra("college");
        score=intent.getStringExtra("score");
        sort=intent.getStringExtra("sort");
        tbcollege=intent.getStringExtra("tcollege");
        tbmajor=intent.getStringExtra("tmajor");
        tbshow=intent.getStringExtra("get");
        contact=intent.getStringExtra("contact");

        bname.setText("姓名： "+name);
        bgrade.setText("年级： "+grade);
        bcollege.setText("学院： "+college);
        bmajor.setText("专业： "+major);
        bscore.setText("分数： "+score);
        bsort.setText("排名： "+sort);
        bcontact.setText("联系方式： "+contact);
        tcollege.setText("已保研学校： "+tbcollege);
        tmajor.setText("已保研专业： "+tbmajor);
        show.setText("本科阶段所获奖励： "+tbshow);
    }
    }
