package com.example.finalexam;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuaListAdapter extends ArrayAdapter {
    private static final String TAG = "MyAdapter";

    public GuaListAdapter(@NonNull Context context, int resource, ArrayList<HashMap<String,String>> list, List<String> list1) {
        super(context, resource,list);
    }
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemView = convertView;
        if (itemView == null) {
            itemView = LayoutInflater.from(getContext()).inflate(R.layout.gualist_item,
                    parent,
                    false);
        }
        Map<String, String> map = (Map<String, String>) getItem(position);
      //  List<String> list=(ArrayList<String>)getItem(position);
        TextView index = (TextView) itemView.findViewById(R.id.index);
        TextView content = (TextView) itemView.findViewById(R.id.content);
        TextView count=itemView.findViewById(R.id.count);

        index.setText(map.get("index"));
        content.setText(map.get("content"));
        content.setTextSize(20);
        count.setText("热度"+" "+map.get("count"));

        if(map.get("index").equals("1")){
            index.setTextColor(Color.rgb(255,0,0));
            index.setTextSize((float) 23);
            index.getPaint().setFakeBoldText(true);
        }
        if(map.get("index").equals("2")){
            index.setTextColor(Color.rgb(255,0,0));
            index.setTextSize((float) 23);
            index.getPaint().setFakeBoldText(true);
        }
        if(map.get("index").equals("3")){
            index.setTextColor(Color.rgb(	255,0,0));
            index.setTextSize((float) 23);
            index.getPaint().setFakeBoldText(true);
        }

        return itemView;
    }
}
