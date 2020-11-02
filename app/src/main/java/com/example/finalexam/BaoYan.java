package com.example.finalexam;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import androidx.fragment.app.Fragment;

public class BaoYan extends Fragment implements View.OnClickListener {

    Button b1;
    Button b2;
    Button b3;
    ListView list;
    ImageButton image;
    Intent intent;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.baoyan, container);

    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        b1=getView().findViewById(R.id.b1);
        b2=getView().findViewById(R.id.b2);
        b3=getView().findViewById(R.id.b3);
        list=getView().findViewById(R.id.list);
        image=getView().findViewById(R.id.imageButton2);
        image.setOnClickListener(this);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int count=1;
        if(view.getId()==R.id.b1){
            b1.setTextColor(Color.rgb(255,140,0));
            count=1;
        }
        if(view.getId()==R.id.b2){
           b2.setTextColor(Color.rgb(255,140,0));
           count=2;
        }
        if(view.getId()==R.id.b3){
            b3.setTextColor(Color.rgb(255,140,0));
            count=3;
        }
        if(view.getId()==R.id.imageButton2){
            intent=new Intent(getActivity(), Baoyan_Editor.class);
            intent.putExtra("index",String.valueOf(count));
            startActivity(intent);
        }
    }

}
