package com.example.finalexam;

import android.content.Intent;
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

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
         //data=getIntent();
        if(requestCode==1 && resultCode==2) {
            Bundle bundle = data.getExtras();
            gettitle=bundle.getString("title","");
            getcontent=bundle.getString("content","");
            getauthor=bundle.getString("author","");
            getdate=bundle.getString("date","");
            Log.i(TAG, "onActivityResult: "+gettitle);
            title.setText(gettitle);
            content.setText(getcontent);
            author.setText(getauthor);
            date.setText(getdate);
            getInfo();
        }
    }
    @Override
    public void onClick(View view) {

    }
   protected void onResume() {
        super.onResume();
        getInfo();
    }
    public void getInfo(){
        Bundle bundle =new Bundle();
        gettitle=bundle.getString("title","");
        getcontent=bundle.getString("content","");
        getauthor=bundle.getString("author","");
        getdate=bundle.getString("date","");
        Log.i(TAG, "onActivityResult: "+gettitle);
        title.setText(gettitle);
        content.setText(getcontent);
        author.setText(getauthor);
        date.setText(getdate);
    }
}
