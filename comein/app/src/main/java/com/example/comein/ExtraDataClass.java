package com.example.comein;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class ExtraDataClass extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.extra_data_activity);
        Button button = findViewById(R.id.in);
        button.setOnClickListener(v -> {
            EditText editText = findViewById(R.id.password);
            String data = editText.getText().toString();
            Intent intent = new Intent(ExtraDataClass.this,Second.class);
            intent.putExtra("input",data);
            startActivity(intent);
        });
    }
}