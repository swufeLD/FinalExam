package com.example.finalexam;

import android.content.Intent;
import android.net.Uri;
import android.net.UrlQuerySanitizer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import  org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HotTop extends AppCompatActivity implements Runnable, AdapterView.OnItemClickListener {
         public static final String TAG ="HotTop";
         List<String> href;
         List<HashMap<String,String>> hreflist;
          List<HashMap<String,String>>titlelist;
          List<HashMap<String,String>> msg_title;
         Handler handler;
         ListView listView;
         Uri uri;
    Intent intent;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.mylist);

       listView=findViewById(R.id.mylist);
       listView.setOnItemClickListener(this);

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
        href=new ArrayList<>();

        int count=1;

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

            href.add(h);
            count++;

            Log.i(TAG, "run: href"+h);
            Log.i(TAG, "run: title"+t);

        }
        Message  msg=handler.obtainMessage(0);
        msg.obj=titlelist;
        handler.sendMessage(msg);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        uri=Uri.parse(href.get(position));
        Log.i(TAG, "onItemClick: "+ uri);
        //Uri.parse("http://www.baidu.com")
        intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}
