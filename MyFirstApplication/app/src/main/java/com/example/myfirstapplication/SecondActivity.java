package com.example.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.second_layout);
        Toolbar toolbar = findViewById(R.id.tf);
        toolbar.setNavigationOnClickListener(v -> {
            onBackPressed();
        });
        Button button1 = findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                Toast.makeText(SecondActivity.this,
                        "豪杰还是强的一批",Toast.LENGTH_SHORT).show();
                Intent intent4 = new Intent(SecondActivity.this,ThirdActivity.class);
                startActivity(intent4);
            }
        });
        Button button2 = findViewById(R.id.button_2);
        button2.setOnClickListener(v2 -> {Toast.makeText(SecondActivity.this,
                "又起飞咯！",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(SecondActivity.this,FourActivity.class);
        startActivity(intent);
        ;});
        Button button3 = findViewById(R.id.button_3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SecondActivity.this,"学习愉快",Toast.LENGTH_SHORT).show();
                Intent intent3 = new Intent(Intent.ACTION_VIEW);
                intent3.setData(Uri.parse("https://www.bilibili.com/video/BV17s411N78s?spm_id_from=333.999.0.0"));
                startActivity(intent3);
            }
        });
        Intent intent = getIntent();
        String data = intent.getStringExtra("extra data");
        Log.d("secondActivity",data);
    }
}