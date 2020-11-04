package com.example.finalexam;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class BaoYan2 extends AppCompatActivity implements AdapterView.OnClickListener {

    Button b1;
    Button b2;
    Button b3;
    ListView list;
    ImageButton image;
    Intent intent;

    ArrayList<EdgeBYP> edgeBYPArrayList;
    ArrayList<HashMap<String,String>> arrayList;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.baoyan);

        b1= findViewById(R.id.b1);
        b2= findViewById(R.id.b2);
        b3= findViewById(R.id.b3);
        list= findViewById(R.id.list);
        image= findViewById(R.id.imageButton2);
        image.setOnClickListener(this);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {
        int count=1;
        if(view.getId()==R.id.b1){
            b1.setTextColor(Color.rgb(255,140,0));
            b2.setTextColor(Color.rgb(	0,0,0));
            b3.setTextColor(Color.rgb(	0,0,0));
            count=1;
            getEdge();
            EdgeBYPAdapter edgeBYPAdapter=new EdgeBYPAdapter(this,R.layout.edge_item,arrayList);
            list.setAdapter(edgeBYPAdapter);
        }
        if(view.getId()==R.id.b2){
            b2.setTextColor(Color.rgb(255,140,0));
            b1.setTextColor(Color.rgb(	0,0,0));
            b3.setTextColor(Color.rgb(	0,0,0));
            count=2;
        }
        if(view.getId()==R.id.b3){
            b3.setTextColor(Color.rgb(255,140,0));
            count=3;
            intent=new Intent(this,BYShow_history.class);
            startActivity(intent);
            b1.setTextColor(Color.rgb(	0,0,0));
            b2.setTextColor(Color.rgb(	0,0,0));
        }
        if(view.getId()==R.id.imageButton2){
            intent=new Intent(this, Baoyan_Editor.class);
            intent.putExtra("index",String.valueOf(count));
            startActivity(intent);
        }
    }
    public  void getEdge(){
        edgeBYPArrayList=new ArrayList<EdgeBYP>();
        arrayList=new ArrayList<HashMap<String, String>>();
        EdgeBYPManager edgeBYPManager=new EdgeBYPManager(this);
        edgeBYPArrayList=edgeBYPManager.list(35);
        for(int i=0;i<edgeBYPArrayList.size();i++){
            HashMap<String,String> map=new HashMap<>();
            map.put("index",edgeBYPArrayList.get(i).getTitle());
            map.put("content",edgeBYPArrayList.get(i).getContent());
            arrayList.add(map);
        }
    }
}
