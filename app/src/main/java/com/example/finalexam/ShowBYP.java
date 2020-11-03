package com.example.finalexam;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ShowBYP extends AppCompatActivity {
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
        bmajor=findViewById(R.id.major);
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
        major=intent.getStringExtra("major");
        college=intent.getStringExtra("college");
        score=intent.getStringExtra("score");
        sort=intent.getStringExtra("sort");
        tbcollege=intent.getStringExtra("tcollege");
        tbmajor=intent.getStringExtra("tshow");
        tbshow=intent.getStringExtra("get");
        contact=intent.getStringExtra("contact");

        bname.setText(name);
        bgrade.setText(grade);
        bcollege.setText(college);
        bmajor.setText(major);
        bscore.setText(score);
        bsort.setText(sort);
        bcontact.setText(contact);
        tcollege.setText(tbcollege);
        tmajor.setText(tbmajor);
        show.setText(tbshow);
    }
    }
