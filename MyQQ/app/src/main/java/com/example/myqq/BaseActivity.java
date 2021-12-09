package com.example.myqq;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        String TAG = "data";
        Log.d(TAG, "onCreate: "+getClass().getSimpleName());
        ActivityCollector.addActivity(this);
    }

    //重写onDestroy方法,在其中调用removeActivity方法
    @Override
    protected void onDestroy(){
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }
}
