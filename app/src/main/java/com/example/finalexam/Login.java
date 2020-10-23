package com.example.finalexam;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity implements  RadioGroup.OnCheckedChangeListener, View.OnClickListener {
    Intent intent;
    RadioButton rb1;
    RadioButton rb2;
    RadioGroup rg;
    Button btn3;
    TextView username;
    TextView psw;
    boolean flag;
    SharedPreferences sharedPreferences;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        rg=findViewById(R.id.radiogroup);
        rb1=findViewById(R.id.radioButton);
        rb2=findViewById(R.id.radioButton2);
        rg.setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener) this);

        btn3=findViewById(R.id.btn3);
        btn3.setOnClickListener(this);

        username=findViewById(R.id.username);
        psw=findViewById(R.id.Password);
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
    public void onCheckedChanged(RadioGroup radioGroup, int id) {
        switch (id){
            case R.id.radioButton:
                flag=true;

             case R.id.radioButton2:
                 flag=false;

              default:
                 break;
            }
    }

    @Override
    public void onClick(View view) {
        String name = username.getText().toString();
        String p=psw.getText().toString();
           // 确认数据库中是否存在该用户
        UserManager userManager=new UserManager(this);
        boolean nameflag=userManager.findByName(name);

           if(nameflag){
               if(userManager.findPsw(name).equals(p)){
                   intent=new Intent(this,MainActivity.class);
                   startActivity(intent);

                   if(flag){
                       //将数据存入文件，保存用户状态
                       sharedPreferences=getSharedPreferences("login", Activity.MODE_PRIVATE);
                       SharedPreferences.Editor editor=sharedPreferences.edit();
                       editor.putString("username",name);
                       editor.putString("psw",p);
                       editor.apply();
                   }
               }else{
                   Toast.makeText(this,"密码错误，请重新输入",Toast.LENGTH_LONG).show();
                   psw.setText("");
               }

           }else{
               Toast.makeText(this,"用户名错误，请重新输入",Toast.LENGTH_LONG).show();
               username.setText("");
           }
    }
}
