package com.example.finalexam;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
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
    public  static final String TAG="GuaList";
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
        init();
    }
public void init(){
        listmap=new ArrayList<HashMap<String, String>>();
        list=new ArrayList<>();
        guaMessages=new ArrayList<GuaMessage>();

        GuaManager guaManager=new GuaManager(this);
        guaMessages=guaManager.list(35);
    Log.i(TAG, "init: "+guaMessages);
        int k=1;
        for(int i=0;i<guaMessages.size();i++){
            HashMap<String,String> map=new HashMap<String, String>();
            map.put("index",String.valueOf(k));
            map.put("content",guaMessages.get(i).getTitle());
            map.put("count",String.valueOf(guaMessages.get(i).getCount()));
            listmap.add(map);
            list.add(String.valueOf(guaMessages.get(i).getCount()));
            k++;
            Log.i(TAG, "init: "+map);
        }
        GuaListAdapter guaListAdapter=new GuaListAdapter(this,R.layout.gualist_item,listmap);
        listView.setAdapter(guaListAdapter);
}
    @Override
    public void onClick(View view) {
        intent=new Intent(this,Gua_EditorMessage.class);
        startActivity(intent);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        SharedPreferences sharedPreferences=getSharedPreferences("Gua", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
              int index =guaMessages.get(position).getId();
              String title=guaMessages.get(position).getTitle();
              String content=guaMessages.get(position).getContent();
              String author=guaMessages.get(position).getAuthor();
              String date=guaMessages.get(position).getDate();
              String comment=guaMessages.get(position).getComment();

              Log.i(TAG, "onItemClick: "+title);

              editor.putString("id",String.valueOf(index));
             editor.putString("title",title);
             editor.putString("content",content);
             editor.putString("author",author);
             editor.putString("date",date);
             editor.putString("comment",comment);
             editor.apply();
             intent=new Intent(this,ShowGua.class);
             startActivity(intent);
    }
}