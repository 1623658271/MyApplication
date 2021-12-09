package com.example.myqq;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class TitleLayout extends LinearLayout {
    public TitleLayout(Context context, AttributeSet attrs){
        super(context,attrs);
        LayoutInflater.from(context).inflate(R.layout.title,this);
        Button btBack = findViewById(R.id.title_back);
        Button btEdit = findViewById(R.id.title_edit);
        btBack.setOnClickListener(v -> ((Activity)getContext()).finish());
        btEdit.setOnClickListener(v -> Toast.makeText(getContext(),"你点个锤子",Toast.LENGTH_SHORT).show());
    }
}
