package com.example.myqq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import java.util.Objects;

public class Hello_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);
        Objects.requireNonNull(getSupportActionBar()).hide();
        ProgressBar progressBar = findViewById(R.id.pb_upLoad);
        progressBar.setVisibility(View.VISIBLE);
        Intent intent = new Intent(Hello_activity.this,MainActivity.class);
        new Thread(){
            @Override
            public void run() {
                try {
                    int i;
                    for(i=10;i!=100;i+=10){
                        progressBar.setProgress(i);
                        Thread.sleep(200);
                    }
                    progressBar.setProgress(i);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }
}