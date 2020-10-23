package com.example.finalexam;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Register extends AppCompatActivity  implements View.OnClickListener {
    Intent intent;
    Button btn4;
    TextView reg_name;
    TextView reg_email;
    TextView psw1;
    TextView psw2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        btn4=findViewById(R.id.btn4);
        btn4.setOnClickListener(this);

        reg_name=findViewById(R.id.reg_name);
        reg_email=findViewById(R.id.reg_email);
        psw1=findViewById(R.id.psw1);
        psw2=findViewById(R.id.psw2);
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
    public void onClick(View view) {
       if(view.getId()==R.id.btn4){
           String email=reg_email.getText().toString();
           String p1=psw1.getText().toString();
           String p2=psw2.getText().toString();
           //判断邮箱
           if(isEmail(email)){
               //判断密码
               if(!p1.equals(p2)){
                   psw1.setText("");
                   psw2.setText("");
                   Toast.makeText(this,"两次密码不正确",Toast.LENGTH_LONG).show();
               }else{
                   intent=new Intent(this, Register_Sucessful.class);
                   startActivity(intent);
                   //将数据放入数据库
               }
           }else{
               Toast.makeText(this,"邮箱格式错误",Toast.LENGTH_LONG).show();
               reg_email.setText("");
           }

       }
    }
    public static boolean isEmail(String email){
        if (null==email || "".equals(email)) return false;
        //Pattern p = Pattern.compile("\\w+@(\\w+.)+[a-z]{2,3}"); //简单匹配
        Pattern p =  Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");//复杂匹配
        Matcher m = p.matcher(email);
        return m.matches();
    }
}
