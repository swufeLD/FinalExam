package com.example.finalexam;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import  org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HotTop extends AppCompatActivity implements Runnable {
         public static final String TAG ="HotTop";
         List<HashMap<String,String>> hreflist;
          List<HashMap<String,String>>titlelist;
          List<HashMap<String,String>> msg_title;
         Handler handler;
         ListView listView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.mylist);

       listView=findViewById(R.id.mylist);

       Thread t=new Thread(this);
       t.start();

       handler=new Handler(){
           public void handleMessage(Message msg){
               super.handleMessage(msg);

               if(msg.what==0){
                   msg_title=(ArrayList<HashMap<String, String>>)msg.obj;
                   MyListAdapter myListAdapter=new MyListAdapter(HotTop.this,
                           R.layout.list_item, (ArrayList<HashMap<String, String>>)msg_title);
                   listView.setAdapter(myListAdapter);
               }
           }
       };

    }
    @Override
    public void run() {
        String url="https://s.weibo.com/top/summary";
        Document doc= null;

        hreflist=new ArrayList<HashMap<String, String>>();
        titlelist=new ArrayList<HashMap<String, String>>();

        int count=0;

        try {
            doc= (Document) Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements elements= (Elements) doc.getElementsByTag("td");
        for(int i=1;i<elements.size();i+=3){
            Elements link= elements.get(i).select("a[href]");
            String h=link.attr("abs:href");
            String t=link.text();

            HashMap<String,String> map=new HashMap<>();
            map.put("index",String.valueOf(count));
            map.put("content",t);
            titlelist.add(map);

            HashMap<String,String> map2=new HashMap<>();
            map2.put("index",String.valueOf(count));
            map2.put("content",h);
            hreflist.add(map2);

            count++;

            Log.i(TAG, "run: href"+h);
            Log.i(TAG, "run: title"+t);

        }
        Message  msg=handler.obtainMessage(0);
        msg.obj=titlelist;
        handler.sendMessage(msg);
    }
}
