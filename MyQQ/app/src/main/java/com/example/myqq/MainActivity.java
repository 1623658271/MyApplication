package com.example.myqq;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private SharedPreferences preferences;
    private final String TAG = "data";
    private CheckBox passwordRemember;
    private SharedPreferences.Editor editor;
    private TextInputLayout textInputLayout11,textInputLayout22;
    private TextInputEditText textInputEditText11,textInputEditText22;
    private Button btLogin;
    private ImageView qqtouxiang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //设置内容视图
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //加载控件
        iniView();

        //文本框监听
        checked();

        //记住密码
        Remember();

        passwordRemember.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(passwordRemember.isChecked()){
                Toast.makeText(MainActivity.this,"记住密码已选中",Toast.LENGTH_SHORT).show();
                editor.putBoolean("isChecked",true).apply();
            }else{
                Toast.makeText(MainActivity.this,"记住密码未选中",Toast.LENGTH_SHORT).show();
                editor.putBoolean("isChecked",false).apply();
            }
        });

        qqtouxiang.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this,"换头像?不存在的",Toast.LENGTH_SHORT).show();
        });
        //添加此活动
        ActivityCollector.addActivity(this);
    }

    //文本框输入监听
    private void checked(){
        textInputEditText11.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(Objects.requireNonNull(textInputEditText11.getText()).toString().length()==0) {
                    textInputLayout11.setError("用户名不能为空！");
                }else {
                    textInputLayout11.setError("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if(Objects.requireNonNull(textInputEditText11.getText()).toString().equals("")) {
                    textInputLayout11.setError("用户名不能为空！");
                }else{
                    textInputLayout11.setError("");
                }
            }
        });
        textInputEditText22.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(Objects.requireNonNull(textInputEditText22.getText()).toString().equals("")){
                    textInputLayout22.setError("密码不能为空！");
                }else {
                    textInputLayout22.setError("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if(Objects.requireNonNull(textInputEditText22.getText()).toString().equals("")){
                    textInputLayout22.setError("密码不能为空！");
                }
            }
        });
    }

    //加载控件的方法
    private void iniView() {
        Objects.requireNonNull(getSupportActionBar()).hide();
        qqtouxiang = findViewById(R.id.image_qqtouxiang);
        textInputEditText11 = findViewById(R.id.textInputEditText11);
        textInputEditText22 = findViewById(R.id.textInputEditText22);
        textInputLayout11 = findViewById(R.id.textInputLayout11);
        textInputLayout22 = findViewById(R.id.textInputLayout22);
        btLogin = findViewById(R.id.comeInButton);
        TextView tv_register = findViewById(R.id.register);
        passwordRemember = findViewById(R.id.checkbox);
        btLogin.setOnClickListener(this);
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        tv_register.setOnClickListener(this);
        editor = preferences.edit();
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    //点击监听
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.comeInButton:
                String text1 = textInputEditText11.getText().toString();
                String text2 = textInputEditText22.getText().toString();
                if(text1.length()!=0 && text2.length()!=0){
                    if (isExist(text1,text2)){
                        Toast.makeText(MainActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
                        editor.putString("PresentUsername", text1);
                        editor.putString("PresentPassword", text2);
                        editor.apply();
                        SecondActivity.actionStart(MainActivity.this, textInputEditText11.getText().toString(), textInputEditText22.getText().toString());
                    } else if(isEmpty()){
                        Toast.makeText(MainActivity.this,"请先注册！",Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(MainActivity.this,"登陆失败,请检查账号密码是否输入正确！",Toast.LENGTH_SHORT).show();
                    }
                }else if(text1.length()==0 && text2.length()!=0){
                    textInputLayout11.setError("用户名不能为空！");
                }else if(text2.length()==0 && text1.length()!=0){
                    textInputLayout22.setError("密码不能为空！");
                }else {
                    textInputLayout11.setError("用户名不能为空！");
                    textInputLayout22.setError("密码不能为空！");
                }

                break;
            case R.id.register:startActivity(new Intent(MainActivity.this,MyDialog.class));break;
        }
    }

    //是否注册过账号
    private boolean isEmpty() {
        boolean flag = true;
        for (int i = 1; i <= 5; i++) {
            String same1 = preferences.getString("Username" + i, null);
            String same2 = preferences.getString("Password" + i, null);
            if (same1 != null && same2 != null) {
                flag = false;
            }
        }
        return flag;
    }

    //输入的账号是否存在且正确
    private boolean isExist(String text1, String text2){
        boolean flag = false;
        for(int i=1;i<=5;i++){
            String same1 = preferences.getString("Username"+i,null);
            String same2 = preferences.getString("Password"+i,null);
            if(text1.equals(same1) && text2.equals(same2)){
                flag = true;
            }
        }
        return flag;
    }

    //记住密码
    private void Remember(){
        boolean isRemember = preferences.getBoolean("isChecked",false);
        if(isRemember){
            passwordRemember.setChecked(true);
            String u = preferences.getString("PresentUsername","");
            String p = preferences.getString("PresentPassword","");
            textInputEditText11.setText(u);
            textInputEditText22.setText(p);
        }
    }

    public void onDestroy(){

        super.onDestroy();
    }

    public void onBackPressed() {
        Log.d(TAG, "onBackPressed: ");
        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
        dialog.setTitle("确定要退出吗？");
        dialog.setCancelable(false);
        dialog.setMessage("退出后将结束程序");
        dialog.setPositiveButton("退出", (dialog1, witch1) -> finish());
        dialog.setNegativeButton("取消", (dialog12, which) -> Toast.makeText(MainActivity.this, "这都不退?(狗头)", Toast.LENGTH_SHORT).show());
        dialog.show();
    }

    //临时保存数据
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState: ");
        String data1 = Objects.requireNonNull(textInputEditText11.getText()).toString();
        String data2 = Objects.requireNonNull(textInputEditText22.getText()).toString();
        outState.putString("data1", data1);
        outState.putString("data2", data2);
    }

    protected void onStop() {
        Log.d(TAG, "onStop: ");
        super.onStop();
    }

    protected void onRestart() {
        Log.d(TAG, "onRestart: ");
        super.onRestart();
    }
}
