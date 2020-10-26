package com.example.finalexam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  implements TabLayout.OnTabSelectedListener {

    TabLayout tab1;
    TabLayout tab2;
    List<String> list_title;
    ViewPager2 vp;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

    }
   public void initViews(){
        updata();
        vp=findViewById(R.id.vp);
        tab2=findViewById(R.id.tab2);
       tab1=findViewById(R.id.tab1);
       for(int i=0;i<list_title.size();i++){
           //还差与fragment相连接；
           tab1.addTab(tab1.newTab().setText(list_title.get(i)));
       }
       tab2.addTab(tab2.newTab().setText("首页").setIcon(R.mipmap.zhu));
       tab2.addTab(tab2.newTab().setText("热榜").setIcon(R.mipmap.re));
       tab2.addTab(tab2.newTab().setText("吃瓜").setIcon(R.mipmap.gua));
       tab2.addTab(tab2.newTab().setText("我的").setIcon(R.mipmap.me));

       tab1.addOnTabSelectedListener(this);
       tab2.addOnTabSelectedListener(this);
       tab1.getTabAt(0).select();
       tab2.getTabAt(0).select();

   }
   public void updata(){
       list_title=new ArrayList<>();
       list_title.add("活动");
       list_title.add("社团");
       list_title.add("兼职");
       list_title.add("考研");
       list_title.add("保研");
       list_title.add("就业");
       list_title.add("出国");
       list_title.add("实习");
       list_title.add("志愿者");
       list_title.add("社会实践");
   }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
           switch (item.getItemId()){
               case R.id.register:
                  intent=new Intent(this, Register.class);
                   startActivity(intent);
               case R.id.login:
                   intent=new Intent(this, Login.class);
                   startActivity(intent);
               default:
                   break;
           }
           return true;
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {

        if(tab.getText().toString().equals("热榜")){
             intent=new Intent(this,HotTop.class);
             startActivity(intent);
        }
        if(tab.getText().toString().equals("吃瓜")){
              //校内信息发布
        }
        if(tab.getText().toString().equals("我的")){
            intent=new Intent(this,Personal.class);
            startActivity(intent);
        }

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}