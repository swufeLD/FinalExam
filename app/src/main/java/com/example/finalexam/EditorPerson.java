package com.example.finalexam;

import android.app.Person;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EditorPerson extends AppCompatActivity implements View.OnClickListener {

    Button save;
    TextView birth;
    TextView age;
    TextView sex;
    TextView grade;
    TextView introduce;

    Intent intent;

    String b;
    String a;
    String s;
    String g;
    String i;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editorperson);

        save=findViewById(R.id.save);
        birth=findViewById(R.id.editbirth);
        age=findViewById(R.id.editage);
        sex=findViewById(R.id.editsex);
        grade=findViewById(R.id.editgrade);
        introduce=findViewById(R.id.editintrodice);

        save.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        b=birth.getText().toString();
        a=age.getText().toString();
        s=sex.getText().toString();
        g=grade.getText().toString();
        i=introduce.getText().toString();

        intent =new Intent(this, Personal.class);
        Bundle bdl=new Bundle();
        bdl.putString("birth",b);
        bdl.putString("age",a);
        bdl.putString("sex",s);
        bdl.putString("grade",g);
        bdl.putString("introduce",i);

        intent.putExtras(bdl);
        setResult(2,intent);
        finish();
    }
}