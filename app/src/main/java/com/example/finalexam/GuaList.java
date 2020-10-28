package com.example.finalexam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuaList extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    ImageButton imagebtn;
    ListView listView;
    Intent intent;
    ArrayList<GuaMessage> guaMessages;
    ArrayList<HashMap<String,String>> listmap;
    List<String>list;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gualist);

        imagebtn=findViewById(R.id.imageButton);
        listView=findViewById(R.id.listview);
        imagebtn.setOnClickListener(this);
        listView.setOnItemClickListener(this);
    }
public void init(){
        GuaManager guaManager=new GuaManager(this);
        guaMessages=guaManager.list(35);
        int k=1;
        for(int i=0;i<guaMessages.size();i++){
            HashMap<String,String> map=new HashMap<String, String>();
            map.put("index",String.valueOf(k));
            map.put("count",guaMessages.get(i).getTitle());
            listmap.add(map);
            list.add(String.valueOf(guaMessages.get(i).getCount()));
        }
        GuaListAdapter guaListAdapter=new GuaListAdapter(this,R.layout.gualist_item,listmap,list);
        listView.setAdapter(guaListAdapter);
}
    @Override
    public void onClick(View view) {
        intent=new Intent(this,Gua_EditorMessage.class);
        startActivity(intent);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
             intent=new Intent(this,ShowGua.class);
             startActivity(intent);
    }
}