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

public class ShowSCAdapetr extends ArrayAdapter {
    private static final String TAG = "MyAdapter";

    public ShowSCAdapetr(@NonNull Context context, int resource, ArrayList<HashMap<String,String>> list) {
        super(context, resource,list);
    }
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemView = convertView;
        if (itemView == null) {
            itemView = LayoutInflater.from(getContext()).inflate(R.layout.showsc,
                    parent,
                    false);
        }
        Map<String, String> map = (Map<String, String>) getItem(position);
        TextView aa = (TextView) itemView.findViewById(R.id.aa);
        TextView dd = (TextView) itemView.findViewById(R.id.dd);
        TextView tt= (TextView) itemView.findViewById(R.id.tt);
        TextView cc = (TextView) itemView.findViewById(R.id.cc);

        aa.setText(map.get("aa"));
        dd.setText(map.get("dd"));
        tt.setText(map.get("tt"));
        cc.setText(map.get("cc"));

        return itemView;
    }
}
