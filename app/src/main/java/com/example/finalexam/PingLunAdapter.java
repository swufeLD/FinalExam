package com.example.finalexam;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PingLunAdapter extends ArrayAdapter implements View.OnClickListener {
    ImageButton bt;
    public PingLunAdapter(@NonNull Context context, int resource, ArrayList<HashMap<String,String>> list) {
        super(context, resource,list);
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemView = convertView;
        if (itemView == null) {
            itemView = LayoutInflater.from(getContext()).inflate(R.layout.pinglun_item,
                    parent,
                    false);
        }
        Map<String, String> map = (Map<String, String>) getItem(position);
        TextView at = (TextView) itemView.findViewById(R.id.at);
        TextView et = (TextView) itemView.findViewById(R.id.et);
        bt=(ImageButton) itemView.findViewById(R.id.bt);
        bt.setOnClickListener(this);

        at.setText(map.get("at"));
        et.setText(map.get("et"));

        return itemView;
    }

    @Override
    public void onClick(View view) {
        bt.setBackgroundResource(R.drawable.love);
        bt.setBackgroundColor(Color.rgb(220,20,60));
    }
}
