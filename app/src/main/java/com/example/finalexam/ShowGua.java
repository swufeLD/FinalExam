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
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShowGua extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = "ShoewGus";

    TextView title;
    TextView content;
    TextView showping;
    TextView author;
    TextView date;
    ListView plist;
    Button guanzhu;

    ImageButton shoucang;
    ImageButton dianzan;
    ImageButton pinglun;

    String gettitle;
    String getcontent;
    String getauthor;
    String getdate;
    String getid;
    String getcomment;

    Intent intent;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showgua);
        initView();
        getInfo();
    }

    public void initView() {
        plist=findViewById(R.id.plist);

        title = findViewById(R.id.title);
        content = findViewById(R.id.content);
        author = findViewById(R.id.author);
        date = findViewById(R.id.date);
        showping = findViewById(R.id.show);

        guanzhu = findViewById(R.id.guanzhu);
        guanzhu.setOnClickListener(this);

        shoucang = findViewById(R.id.shoucang);
        dianzan = findViewById(R.id.dianzan);
        pinglun = findViewById(R.id.pinglun);

        shoucang.setOnClickListener(this);
        dianzan.setOnClickListener(this);
        pinglun.setOnClickListener(this);
        guanzhu.setOnClickListener(this);

        showcomment();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.guanzhu) {
            GuanZhu guanZhu = new GuanZhu(getauthor, getdate);
            GuanZhuManager guanZhuManager = new GuanZhuManager(this);
            guanZhuManager.add(guanZhu);
        }
        if (view.getId() == R.id.shoucang) {
            ShowCang showCang = new ShowCang(getauthor, getdate, gettitle, getcontent);
            ShouCangManager shouCangManager = new ShouCangManager(this);
            shouCangManager.add(showCang);
        }
        if (view.getId() == R.id.pinglun) {
            intent = new Intent(this, Gua_PingLun.class);
            intent.putExtra("title", gettitle);
            intent.putExtra("content", getcontent);
            intent.putExtra("id", getid);
            intent.putExtra("author", getauthor);
            Log.i(TAG, "onClick: "+getauthor);
            startActivity(intent);
        }
    }

    protected void onResume() {
        super.onResume();
        showcomment();
        getInfo();
    }

    public void getInfo() {
        SharedPreferences sharedPreferences = getSharedPreferences("Gua", Activity.MODE_PRIVATE);
        getid = sharedPreferences.getString("id", "");
        gettitle = sharedPreferences.getString("title", "");
        getcontent = sharedPreferences.getString("content", "");
        getauthor = sharedPreferences.getString("author", "");
        getdate = sharedPreferences.getString("date", "");
        Log.i(TAG, "onActivityResult: " + gettitle);
        getcomment = sharedPreferences.getString("comment", "");

        title.setText("话题：  " + gettitle);
        content.setText("内容：  " + getcontent);
        author.setText("作者： " + getauthor);
        date.setText("时间： " + getdate);
    }

    public void showcomment() {
        if(getcomment!=null){
            String temp[] = getcomment.split("#");
            ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
            for (int i = 0; i < temp.length; i++) {
                String ss[] = temp[i].split("@");
                HashMap<String,String>map=new HashMap<>();
                map.put("at",ss[0]);
                map.put("et",ss[1]);
                list.add(map);
            }
            PingLunAdapter pingLunAdapter=new PingLunAdapter(this,R.layout.pinglun_item,list);
            plist.setAdapter(pingLunAdapter);
        }
    }
}