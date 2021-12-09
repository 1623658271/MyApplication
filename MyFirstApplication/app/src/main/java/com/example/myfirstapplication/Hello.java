package com.example.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Hello extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hello_activity);
        Button button = findViewById(R.id.button_in);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(Hello.this,MainFirstActivity.class);
            startActivity(intent);
        });
    }
    @Override
    protected void onRestart(){
        finish();
        super.onRestart();
    }
}