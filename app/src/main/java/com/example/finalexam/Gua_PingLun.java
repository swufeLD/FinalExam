package com.example.finalexam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Gua_PingLun extends AppCompatActivity implements View.OnClickListener {
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

        t.setText(title);
        c.setText(content);
    }
    @Override
    public void onClick(View view) {
        String comment=author+"*"+e.getText().toString();
        GuaManager guaManager=new GuaManager(this);
        guaManager.insertcomment(Integer.parseInt(id),comment);
    }
}
