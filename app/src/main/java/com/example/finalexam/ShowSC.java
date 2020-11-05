package com.example.finalexam;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShowSC extends AppCompatActivity implements AdapterView.OnItemClickListener {
    List<ShowCang>list;
    ArrayList<HashMap<String,String>>listmap;
    ListView listView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mylist);

        listView=findViewById(R.id.mylist);
        listView.setOnItemClickListener(this);
        showSC();
    }

public void showSC(){
        list=new ArrayList<ShowCang>();
        listmap=new ArrayList<HashMap<String, String>>();
        ShouCangManager shouCangManager=new ShouCangManager(this);
        list=shouCangManager.listAll();
        for(int i=0;i<list.size();i++){
            HashMap<String,String> map=new HashMap<>();
            map.put("aa",list.get(i).getAuthor());
            map.put("dd",list.get(i).getDate());
            map.put("tt",list.get(i).getTitle());
            map.put("cc",list.get(i).getContent());
            listmap.add(map);
        }
        ShowSCAdapetr showSCAdapetr=new ShowSCAdapetr(this,R.layout.showsc,listmap);
        listView.setAdapter(showSCAdapetr);
}

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int postion, long id) {
        //根据作者，题目，找到 消息的全貌，放入文件；

        //跳转到showegua
    }
}
