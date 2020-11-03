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
import java.util.Map;

public class BaoYanAdapter extends ArrayAdapter {
    private static final String TAG = "MyAdapter";

    public BaoYanAdapter(@NonNull Context context, int resource, ArrayList<HashMap<String,String>> list) {
        super(context, resource,list);
    }
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemView = convertView;
        if (itemView == null) {
            itemView = LayoutInflater.from(getContext()).inflate(R.layout.baoyan_item,
                    parent,
                    false);
        }
        Map<String, String> map = (Map<String, String>) getItem(position);
        TextView college = (TextView) itemView.findViewById(R.id.college);
        TextView major = (TextView) itemView.findViewById(R.id.major);
        TextView id = (TextView) itemView.findViewById(R.id.id);
        TextView name=itemView.findViewById(R.id.name);

        college.setText(map.get("college"));
        major.setText(map.get("major"));
        id.setText(map.get("id"));
        name.setText(map.get("name"));

        return itemView;
    }
}
