package com.example.finalexam;

import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BYShow_history extends AppCompatActivity implements View.OnClickListener , AdapterView.OnItemSelectedListener {
    public static final String TAG="BYShow_history ";

    Spinner sp1;
    Spinner sp2;
    Button b1;

    String arr1[];
    String arr2[];

    String a1;
    String a2;
    int index1;
    int index2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.by_history);

        sp1=findViewById(R.id.spinner);
        sp2=findViewById(R.id.spinner2);
        b1=findViewById(R.id.button);

        b1.setOnClickListener(this);
        sp1.setOnItemSelectedListener(this);
        sp2.setOnItemSelectedListener(this);

        arr1= new String[]{"请选择年份", "2020", "2019", "2018", "2017", "2016"};
        arr2= new String[]{"请选择学院", "金融学院", "经济信息工程学院", "数学学院", "体育学院", "马克思主义学院"};

        ArrayAdapter<String> adapter1=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arr1);
        ArrayAdapter<String> adapter2=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arr2);

        sp1.setAdapter(adapter1);
        sp2.setAdapter(adapter2);

    }

    @Override
    public void onClick(View view) {
        //查询数据库并显示
        if(index1==0 && index2==0){

        }else if(index1==0 && index2!=0){

        }else if(index2==0 && index1!=0){

        }else{

        }
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

}
