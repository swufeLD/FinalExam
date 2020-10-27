package com.example.finalexam;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EditorPsw extends AppCompatActivity implements View.OnClickListener {

    TextView old;
    TextView new1;
    TextView new2;
    Button b1;
    Button b2;

    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editorpsw);

        old=findViewById(R.id.editTextTextPassword);
        new1=findViewById(R.id.editTextTextPassword2);
        new2=findViewById(R.id.editTextTextPassword3);
        b1=findViewById(R.id.button4);
        b1.setOnClickListener(this);
        b2=findViewById(R.id.button5);
        b2.setOnClickListener(this);

    }

    public void Judge(){
        sharedPreferences=getSharedPreferences("login", Activity.MODE_PRIVATE);
        String savePsw=sharedPreferences.getString("psw","");
        String savename=sharedPreferences.getString("username","");

        String oldpsw=old.getText().toString();
        String new1psw=new1.getText().toString();
        String new2psw=new2.getText().toString();

        if(oldpsw.equals(savePsw)){
            if(new1psw.equals(new2psw)){
                Toast.makeText(this,"密码修改成功！",Toast.LENGTH_LONG).show();
                 //修改登陆文件密码
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("password",new1psw);
               //修改数据对应密码
               UserManager userManager=new UserManager(this);
               userManager.updata(savename,new1psw);

            }else{
                Toast.makeText(this,"两次输入不正确，请重新输入！",Toast.LENGTH_LONG).show();;
                new1.setText("");
                new2.setText("");
            }

        }else{
            Toast.makeText(this,"旧密码输入不正确，请重新输入！",Toast.LENGTH_LONG).show();;
            old.setText("");
        }
    }

    @Override
    public void onClick(View view) {
             if(view.getId()==R.id.button4){
                 //跳转手机登录
             }
             if(view.getId()==R.id.button5){
                 Judge();
             }
    }
}
