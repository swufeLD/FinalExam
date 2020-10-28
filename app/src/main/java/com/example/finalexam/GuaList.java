package com.example.finalexam;

import android.content.Intent;
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
        GuaListAdapter guaListAdapter=new GuaListAdapter(this,R.layout.gualist_item,listmap,list);
        listView.setAdapter(guaListAdapter);
}
    @Override
    public void onClick(View view) {
        intent=new Intent(this,Gua_EditorMessage.class);
        startActivity(intent);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

             intent=new Intent(GuaList.this,ShowGua.class);
      //  Log.i(TAG, "onItemClick: "+id);
       // Log.i(TAG, "onItemClick: "+position);
              Bundle bdl=new Bundle();

              String title=guaMessages.get(position).getTitle();
              String content=guaMessages.get(position).getContent();
              String author=guaMessages.get(position).getAuthor();
              String date=guaMessages.get(position).getDate();
              Log.i(TAG, "onItemClick: "+title);
              bdl.putString("title",title);
              bdl.putString("content",content);
              bdl.putString("author",author);
              bdl.putString("date",date);

              intent.putExtras(bdl);
              setResult(2,intent);
              finish();
    }
}