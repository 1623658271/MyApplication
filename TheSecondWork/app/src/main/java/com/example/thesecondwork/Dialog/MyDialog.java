package com.example.thesecondwork.Dialog;

import android.app.Activity;
import android.app.Dialog;
import android.app.backup.SharedPreferencesBackupHelper;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.thesecondwork.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MyDialog extends Dialog implements View.OnClickListener {

    private Context context;
    private int LayoutResId;
    private Button bt_register;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private TextInputEditText editText1,editText2;
    private WindowManager windowManager;
    private WindowManager.LayoutParams lp;
    private Display display;
    private Window dialogWindow;
    private TextInputLayout textInputLayout1,textInputLayout2;

    public MyDialog(Context context, int LayoutResId) {
        super(context, R.style.MyDialog);
        this.context = context;
        this.LayoutResId = LayoutResId;
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LayoutResId);

        iniView();
        iniEvent();
    }

    public void iniView(){
        dialogWindow = getWindow();
        windowManager = ((Activity) context).getWindowManager();
        textInputLayout1 = findViewById(R.id.register_username_inputLayout);
        textInputLayout2 = findViewById(R.id.register_password_inputLayout);
        display = windowManager.getDefaultDisplay();
        lp = getWindow().getAttributes();
        bt_register = findViewById(R.id.bt_register);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);

        editText1 = findViewById(R.id.register_username_editText);
        editText2 = findViewById(R.id.register_password_editText);
    }

    public void iniEvent(){
        dialogWindow.setGravity(Gravity.CENTER);
        setCanceledOnTouchOutside(true);
        lp.width = display.getWidth()*4/5;
        getWindow().setAttributes(lp);
        bt_register.setOnClickListener(MyDialog.this);
    }

    @Override
    public void onClick(View v) {
        dismiss();
        switch (v.getId()) {
            case R.id.bt_register: Register();
        }
    }

    private void Register() {
        editor = sharedPreferences.edit();
        String text1 = editText1.getText().toString();
        String text2 = editText2.getText().toString();
        if (sharedPreferences.getString("password",null)==null && sharedPreferences.getString("username",null)==null) {
            if (text1.equals("2021214339") && !text2.equals("")) {
                editor.putString("username", text1);
                editor.putString("password", text2);
                editor.commit();
                Toast.makeText(context, "创建成功！", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(context, "请检查是否输入正确！", Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(context, "冉卷王只有一个！因此只能注册一次！", Toast.LENGTH_SHORT).show();
        }
    }
}
