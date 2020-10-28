package com.example.finalexam;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ShowGua extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG="ShoewGus";

    TextView title;
    TextView content;
    TextView showping;
    TextView author;
    TextView date;

    Button guanzhu;

    ImageButton shoucang;
    ImageButton dianzan;
    ImageButton pinglun;

    String gettitle;
    String getcontent;
    String getauthor;
    String getdate;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showgua);
        initView();
        getInfo();
    }
    public void initView(){
        title=findViewById(R.id.title);
        content=findViewById(R.id.content);
        author=findViewById(R.id.author);
        date=findViewById(R.id.date);
        showping=findViewById(R.id.show);

        guanzhu=findViewById(R.id.guanzhu);
        guanzhu.setOnClickListener(this);

        shoucang=findViewById(R.id.shoucang);
        dianzan=findViewById(R.id.dianzan);
        pinglun=findViewById(R.id.pinglun);

        shoucang.setOnClickListener(this);
        dianzan.setOnClickListener(this);
        pinglun.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

    }
   protected void onResume() {
        super.onResume();
        getInfo();
    }
    public void getInfo(){
       SharedPreferences sharedPreferences=getSharedPreferences("Gua", Activity.MODE_PRIVATE);
        gettitle=sharedPreferences.getString("title","");
        getcontent=sharedPreferences.getString("content","");
        getauthor=sharedPreferences.getString("author","");
        getdate=sharedPreferences.getString("date","");
        Log.i(TAG, "onActivityResult: "+gettitle);
        title.setText("话题：  "+gettitle);
        content.setText("内容：  "+getcontent);
        author.setText("作者： "+getauthor);
        date.setText("时间： "+getdate);
    }
}
