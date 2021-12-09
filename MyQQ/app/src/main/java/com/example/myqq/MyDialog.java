package com.example.myqq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class MyDialog extends AppCompatActivity {

    private Button register_button,delete_button;
    private SharedPreferences preferences;
    private TextInputLayout textInputLayout1,textInputLayout2;
    private TextInputEditText textInputEditText1,textInputEditText2;
    private SharedPreferences.Editor editor;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_dialog);
        iniView();
        check();
        register_button.setOnClickListener(v -> iniData());
        delete_button.setOnClickListener(v -> {
            SharedPreferences.Editor editor2 = preferences.edit();
            for(int i=1;i<=5;i++) {
                editor2.putString("Username"+i,null);
                editor2.putString("Password"+i,null);
                editor2.apply();
            }
            editor2.clear();
            Toast.makeText(MyDialog.this,"清空成功！",Toast.LENGTH_SHORT).show();
        });
    }

    private void check() {
        textInputEditText2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(Objects.requireNonNull(textInputEditText2.getText()).toString().equals("")){
                    textInputLayout2.setError("密码不能为空！");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if(Objects.requireNonNull(textInputEditText2.getText()).toString().equals("")){
                    textInputLayout2.setError("密码不能为空！");
                }else if(!textInputEditText2.getText().toString().matches("^[A-Z][0-9A-Za-z]+$")){
                    textInputLayout2.setError("密码必须由字母或数字组成,且首位必须为大写字母!");
                }else if(textInputEditText2.getText().toString().length()<6 || textInputEditText2.getText().toString().length()>12){
                        textInputLayout2.setError("密码长度为6~12！");
                } else {
                    textInputLayout2.setError("");
                }
            }
        });
        textInputEditText1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(Objects.requireNonNull(textInputEditText1.getText()).toString().equals("")) {
                    textInputLayout1.setError("用户名不能为空！");
                }else {
                    textInputLayout1.setError("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if(Objects.requireNonNull(textInputEditText1.getText()).toString().length()>10){
                    textInputLayout1.setError("用户名最多输入10个字符！");
                }else if(textInputEditText1.getText().toString().equals("")){
                    textInputLayout1.setError("用户名不能为空！");
                }
                else{
                    textInputLayout1.setError("");
                }
            }
        });
    }

    private boolean isRightName(){
        return Objects.requireNonNull(textInputEditText1.getText()).toString().length()<=10;
    }

    private boolean isRightPassword1(){
        return Objects.requireNonNull(textInputEditText2.getText()).toString().length()>=6 || textInputEditText2.getText().toString().length()<=12;
    }

    private boolean isRightPassword2(){
        return Objects.requireNonNull(textInputEditText2.getText()).toString().matches("^[A-Z][0-9A-Za-z]+$");
    }

    protected void iniView(){
        textInputEditText2 = findViewById(R.id.textInputEditText2);
        textInputLayout2 = findViewById(R.id.textInputLayout2);
        textInputEditText1 = findViewById(R.id.textInputEditText1);
        textInputLayout1 = findViewById(R.id.textInputLayout1);
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        register_button = findViewById(R.id.register_button);
        delete_button = findViewById(R.id.delete);
    }
    protected void iniData(){
        String text1 = Objects.requireNonNull(textInputEditText1.getText()).toString();
        String text2 = Objects.requireNonNull(textInputEditText2.getText()).toString();
        editor = preferences.edit();
        if(isRightName() && isRightPassword1() && isRightPassword2()){
            for(int i=1;i<=5;i++){
                String data1 = preferences.getString("Username"+i,null);
                String data2 = preferences.getString("Password"+i,null);
                if(text1.equals(data1)){
                    textInputLayout1.setError("该账号已被注册！");
                    break;
                }else if(data1==null && data2==null && !text1.equals("") && !text2.equals("") && !isFull()){
                    editor.putString("Username"+i,text1);
                    editor.putString("Password"+i,text2);
                    editor.apply();
                    Toast.makeText(this,"注册成功！",Toast.LENGTH_SHORT).show();
                    break;
                }
            }
            if(isFull()){
                Toast.makeText(this, "注册数据不能超过5个！", Toast.LENGTH_SHORT).show();
            }
        }
        if(textInputEditText1.getText().toString().equals("")) {
            textInputLayout1.setError("用户名不能为空！");
        }
        if(!isRightName()){
            textInputLayout1.setError("用户名错误！请查看注册要求！");
        }
        if(textInputEditText2.getText().toString().equals("")){
            textInputLayout2.setError("密码不能为空！");
        }else if(!isRightPassword1() || !isRightPassword2()){
            textInputLayout2.setError("密码错误,请按照要求输入！");
        }
    }


    private boolean isFull(){
        boolean flag = true;
        for(int i=1;i<=5;i++){
            String data1 = preferences.getString("Username"+i,null);
            String data2 = preferences.getString("Password"+i,null);
            if(data1 == null && data2 ==null){
                flag = false;
                break;
            }
        }
        return flag;
    }
}