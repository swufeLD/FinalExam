package com.example.finalexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

}