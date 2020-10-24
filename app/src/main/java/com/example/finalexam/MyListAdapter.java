package com.example.finalexam;

import android.content.Context;
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

public class MyListAdapter extends ArrayAdapter {
    private static final String TAG = "MyAdapter";

    public MyListAdapter(@NonNull Context context, int resource, ArrayList<HashMap<String,String>> list) {
        super(context, resource,list);
    }
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemView = convertView;
        if (itemView == null) {
            itemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,
                    parent,
                    false);
        }
        Map<String, String> map = (Map<String, String>) getItem(position);
        TextView index = (TextView) itemView.findViewById(R.id.index);
        TextView content = (TextView) itemView.findViewById(R.id.content);

        index.setText(map.get("index"));
        content.setText(map.get("content"));

        return itemView;
    }
}
