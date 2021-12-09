package com.example.thesecondwork.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.thesecondwork.Dialog.MyDialog;
import com.example.thesecondwork.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    private MyDialog myDialog;
    private TextView textView;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Button button;
    private TextInputEditText textInputEditText1,textInputEditText2;
    private TextInputLayout textInputLayout1,textInputLayout2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        iniView();
        iniEvent();
    }

    private void iniEvent() {

        textView.setOnClickListener(v -> myDialog.show());
        button.setOnClickListener(v -> {
            String text1 = sharedPreferences.getString("username",null);
            String text2 = sharedPreferences.getString("password",null);
            if(text1==null || text2==null){
                Toast.makeText(this, "请先注册！", Toast.LENGTH_SHORT).show();
            }else {
                if ("".equals(text1) || "".equals(text2)){
                    Toast.makeText(this, "文本框均不能为空！", Toast.LENGTH_SHORT).show();
                }else {
                    if (text1.equals(textInputEditText1.getText().toString()) && text2.equals(textInputEditText2.getText().toString())) {
                        Toast.makeText(this, "登录成功！欢迎来到冉卷王的课表！", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(this,FirstActivity.class));
                    }else {
                        Toast.makeText(this, "登陆失败！请检查学号密码是否输入正确！", Toast.LENGTH_SHORT).show();
                    }
                }
            }



        });
    }

    private void iniView() {
        textInputEditText1 = findViewById(R.id.login_edit_username);
        textInputEditText2 = findViewById(R.id.login_edit_password);
        textInputLayout1 = findViewById(R.id.login_inputLayout_username);
        textInputLayout2 = findViewById(R.id.login_inputLayout_password);
        myDialog = new MyDialog(LoginActivity.this,R.layout.register_dialog);
        button = findViewById(R.id.login);
        textView = findViewById(R.id.ini_register);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor = sharedPreferences.edit();
    }
}