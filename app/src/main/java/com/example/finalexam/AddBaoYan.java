package com.example.finalexam;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class AddBaoYan extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        BaoYanMessage baoYanMessage=new BaoYanMessage("李四","41710079","2017","经济信息工程学院","计算机");
        BaoYanMessage baoYanMessage1=new BaoYanMessage("张三","41610079","2016","经济信息工程学院","计算机");
        BaoYanMessage baoYanMessage2=new BaoYanMessage("小敏","41610069","2016","金融学院","金融学");
        BaoYanManager baoYanManager=new BaoYanManager(this);
        baoYanManager.add(baoYanMessage);
        baoYanManager.add(baoYanMessage1);
        baoYanManager.add(baoYanMessage2);

        BYPMessage bypMessage=new BYPMessage("李四","41710079","西南财经大学","计算机","三好，优干，数模一等奖","QQ:1182522751","90","1/100");
        BYPMessage bypMessage1=new BYPMessage("张三","41610079","西南财经大学","计算机","三好，优干，数模一等奖","QQ:1182522751","90","1/100");
        BYPMessage bypMessage2=new BYPMessage("小敏","41610069","西南财经大学","金融","三好，优干，数模一等奖,国创","QQ:1182522751","90","1/100");
        BYPManager bypManager=new BYPManager(this );
        bypManager.add(bypMessage);
        bypManager.add(bypMessage1);
        bypManager.add(bypMessage2);
    }

}
