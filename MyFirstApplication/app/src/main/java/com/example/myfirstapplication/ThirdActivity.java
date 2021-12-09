package com.example.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.third_activity);
        Toolbar toolbar = findViewById(R.id.tf2);
        toolbar.setNavigationOnClickListener(v -> {
            onBackPressed();
        });
        Button button4 = findViewById(R.id.button_4);
        button4.setOnClickListener(v->{
            Toast.makeText(this,"学习愉快呀",Toast.LENGTH_SHORT).show();
            Intent intent4 = new Intent(Intent.ACTION_VIEW);
            intent4.setData(Uri.parse("https://www.bilibili.com/video/BV1aW411Q7x1?spm_id_from=333.999.0.0"));
            startActivity(intent4);
        });
        Button button5 = findViewById(R.id.button_5);
        button5.setOnClickListener(v -> {
            Toast.makeText(this,"学习愉快呀",Toast.LENGTH_SHORT).show();
            Intent intent5 = new Intent(Intent.ACTION_VIEW);
            intent5.setData(Uri.parse("https://www.bilibili.com/video/BV164411E7Ny?spm_id_from=333.999.0.0"));
            startActivity(intent5);
        });
        Button button6 = findViewById(R.id.button_6);
        button6.setOnClickListener(v -> {
            Toast.makeText(this,"学习愉快呀",Toast.LENGTH_SHORT).show();
            Intent intent6 = new Intent(Intent.ACTION_VIEW);
            intent6.setData(Uri.parse("https://www.bilibili.com/video/BV1jW411J765?spm_id_from=333.999.0.0"));
            startActivity(intent6);
        });
        Button button3 = findViewById(R.id.button_3);
        button3.setOnClickListener(v->{
            Toast.makeText(this,"学习愉快呀",Toast.LENGTH_SHORT).show();
            Intent intent3 = new Intent(Intent.ACTION_VIEW);
            intent3.setData(Uri.parse("https://www.bilibili.com/video/BV1wU4y1u7r9?spm_id_from=333.999.0.0"));
            startActivity(intent3);
        });
    }
}