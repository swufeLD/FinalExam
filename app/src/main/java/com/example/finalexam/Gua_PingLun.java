package com.example.finalexam;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Gua_PingLun extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG="Gua_PingLun";
    TextView t;
    TextView c;
    TextView e;
    Button b;

     Intent intent;

     String id;
     String author;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gua_pinglun);

        t=findViewById(R.id.t);
        c=findViewById(R.id.c);
        e=findViewById(R.id.e);
        b=findViewById(R.id.b);

        b.setOnClickListener(this);

        intent=getIntent();
        String title=intent.getStringExtra("title");
        String content=intent.getStringExtra("content");
        id=intent.getStringExtra("id");
        author=intent.getStringExtra("author");

        t.setText("标题："+"  "+title);
        c.setText("内容："+"  "+content);
    }
    @Override
    public void onClick(View view) {
        if(e.getText().toString()!=null){
            String comment= author + "&" +e.getText().toString();
            Log.i(TAG, "onClick: "+comment);
            GuaManager guaManager=new GuaManager(this);
            guaManager.insertcomment(Integer.parseInt(id),comment);
            Toast.makeText(this,"保存成功",Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(this,"请输入您的评论",Toast.LENGTH_LONG).show();
        }
    }
}
