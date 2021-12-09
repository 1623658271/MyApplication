package com.example.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.Button;

import java.util.Random;

public class FourActivity extends AppCompatActivity {
    private Button mBtnNot;
    private int mwinWidth;
    private int mwinHeight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.four_activity);
        initView();
        initEvent();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        mwinWidth = displayMetrics.widthPixels;
        mwinHeight = displayMetrics.heightPixels;
    }
    private void initView(){
        mBtnNot = findViewById(R.id.btn_main_not);
    }
    private void initEvent(){
        mBtnNot.setOnClickListener(v ->{
            float x = new Random().nextInt(mwinWidth - v.getWidth());
            float y = new Random().nextInt(mwinHeight - v.getHeight());
            v.setX(x);v.setY(y);
        });
    }
}