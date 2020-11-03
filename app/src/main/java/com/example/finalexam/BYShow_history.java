package com.example.finalexam;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class BYShow_history extends AppCompatActivity implements View.OnClickListener , AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener {
    public static final String TAG="BYShow_history ";

    Spinner sp1;
    Spinner sp2;
    Button b1;
    ListView blist;

    String arr1[];
    String arr2[];

    String a1;
    String a2;
    int index1;
    int index2;

    ArrayList<BaoYanMessage> baoYanMessages;
    ArrayList<HashMap<String,String>> list;

    Intent intent;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.by_history);

        sp1=findViewById(R.id.spinner);
        sp2=findViewById(R.id.spinner2);
        b1=findViewById(R.id.button);
        blist=findViewById(R.id.blist);

        b1.setOnClickListener(this);
        sp1.setOnItemSelectedListener(this);
        sp2.setOnItemSelectedListener(this);
        blist.setOnItemClickListener(this);

        arr1= new String[]{"请选择年份", "2020", "2019", "2018", "2017", "2016"};
        arr2= new String[]{"请选择学院", "金融学院", "经济信息工程学院", "数学学院", "体育学院", "马克思主义学院"};

        ArrayAdapter<String> adapter1=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arr1);
        ArrayAdapter<String> adapter2=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arr2);

        sp1.setAdapter(adapter1);
        sp2.setAdapter(adapter2);

    }

    @Override
    public void onClick(View view) {
        list=new ArrayList<HashMap<String, String>>();
        //查询数据库并显示
        if(index1==0 && index2==0){

            SimpleDateFormat df = new SimpleDateFormat("yyyy");
            String date=df.format(new Date());
            baoYanMessages=new ArrayList<BaoYanMessage>();
            BaoYanManager baoYanManager=new BaoYanManager(this);
            baoYanMessages= baoYanManager.list2(date);

        }else if(index1==0 && index2!=0){

            baoYanMessages=new ArrayList<BaoYanMessage>();
            BaoYanManager baoYanManager=new BaoYanManager(this);
            baoYanMessages= baoYanManager.list(a2);

        }else if(index2==0 && index1!=0){

            baoYanMessages=new ArrayList<BaoYanMessage>();
            BaoYanManager baoYanManager=new BaoYanManager(this);
            baoYanMessages= baoYanManager.list2(a1);

        }else{

            baoYanMessages=new ArrayList<BaoYanMessage>();
            BaoYanManager baoYanManager=new BaoYanManager(this);
            baoYanMessages= baoYanManager.list3(a1,a2);
        }
        //建立适配器
        for(int i=0;i<baoYanMessages.size();i++){
            HashMap<String,String> map=new HashMap<>();
            map.put("college",baoYanMessages.get(i).getCollege());
            map.put("major",baoYanMessages.get(i).getMajor());
            map.put("id",baoYanMessages.get(i).getStuId());
            map.put("name",baoYanMessages.get(i).getName());
            list.add(map);
        }
        BaoYanAdapter baoYanAdapter=new BaoYanAdapter(this,R.layout.baoyan_item,list);
        blist.setAdapter(baoYanAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        if(adapterView.getId()==R.id.spinner){
            a1=arr1[position];
            index1 =sp1.getSelectedItemPosition();
        }
        if(adapterView.getId()==R.id.spinner2){
            a2=arr2[position];
            index2=sp2.getSelectedItemPosition();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        String index =baoYanMessages.get(position).getStuId();
        BYPManager bypManager=new BYPManager(this);
        BYPMessage bypMessage=new BYPMessage();
        bypMessage=bypManager.GetBYP(index);

        intent=new Intent(this,ShowBYP.class);
        intent.putExtra("name",bypMessage.getName());
        intent.putExtra("grade",baoYanMessages.get(position).getGrade());
        intent.putExtra("college",baoYanMessages.get(position).getCollege());
        intent.putExtra("major",baoYanMessages.get(position).getMajor() );
        intent.putExtra("score",bypMessage.getScore());
        intent.putExtra("sort",bypMessage.getSort());
        intent.putExtra("contact",bypMessage.getContact());
        intent.putExtra("tcollege",bypMessage.getTarget());
        intent.putExtra("tmajor",bypMessage.getTargetMajor());
        intent.putExtra("get",bypMessage.getGet());
        startActivity(intent);

    }
}
