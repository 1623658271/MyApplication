package com.example.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainFirstActivity extends AppCompatActivity {
    String TAG = "data";

    MediaPlayer mediaPlayer;
    MediaPlayer mediaPlayer1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "执行onCreate" );
        mediaPlayer=MediaPlayer.create(MainFirstActivity.this,R.raw.pian_ai);
        mediaPlayer1 = MediaPlayer.create(MainFirstActivity.this,R.raw.dnxk);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        Toolbar toolbar = findViewById(R.id.tp);
        toolbar.setNavigationOnClickListener(v -> {
            Toast.makeText(MainFirstActivity.this,"点击了->",Toast.LENGTH_SHORT).show();
        });

        //music
        if(!MediaPlayer.create(MainFirstActivity.this,R.raw.pian_ai).isPlaying() &&
        !MediaPlayer.create(MainFirstActivity.this,R.raw.dnxk).isPlaying()){
            mediaPlayer.start();
        }
        ProgressBar dl1 = findViewById(R.id.dl1);
        Button button1 = findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);
            }
        });
        Button button2 = findViewById(R.id.button_2);
        Button button3 = findViewById(R.id.pause);
        button3.setOnClickListener(v ->{
            if(mediaPlayer.isPlaying() || !mediaPlayer1.isPlaying()){
                mediaPlayer.pause();
                mediaPlayer1.start();
                button2.setText("音乐切换 等你下课       芜湖");
            }else if(mediaPlayer1.isPlaying() || !mediaPlayer.isPlaying()){
                {
                    mediaPlayer1.pause();
                    mediaPlayer.start();
                    button2.setText("音乐切换 偏爱       芜湖");
                }
            }
        });
        Button button5 = findViewById(R.id.con2);
        button5.setOnClickListener(v -> {
            if(!mediaPlayer.isPlaying() && mediaPlayer1.isPlaying()){
                mediaPlayer.start();
            }else if(!mediaPlayer1.isPlaying() && !mediaPlayer.isPlaying()){
                mediaPlayer1.start();
            }
            button2.setText("音乐播放           芜湖");
        });
        Button button4 = findViewById(R.id.con1);
        button4.setOnClickListener(v -> {
            if(mediaPlayer.isPlaying()){
                mediaPlayer.pause();
            }else if(mediaPlayer1.isPlaying()){
                mediaPlayer1.pause();
            }
            button2.setText("音乐暂停           芜湖");
        });

        EditText et1 = findViewById(R.id.text11);
        EditText ed2 = findViewById(R.id.text22);
        button2.setText("音乐播放           芜湖");
        button2.setOnClickListener(v2 -> {
            Toast.makeText(MainFirstActivity.this,
                "起飞！",Toast.LENGTH_SHORT).show();
        String data = "hello secondActivity!";
        Intent intent2 = new Intent(MainFirstActivity.this,SecondActivity.class);
        intent2.putExtra("extra data",data);
        startActivity(intent2);});
        Button btn = findViewById(R.id.enter);
        if(savedInstanceState!=null){
            String st1 = savedInstanceState.getString("data_key");
            et1.setText(st1);
        }
        btn.setOnClickListener(v -> {
            String s1 = et1.getText().toString();
            String s2 = ed2.getText().toString();
            Log.i("data", "输入的内容为"+s1+"\t"+s2);
            if(s1.equals("12345") && !TextUtils.isEmpty(s2)) {
                dl1.setVisibility(View.VISIBLE);
                Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainFirstActivity.this, SB.class);
                String data = s2;
                intent.putExtra("inputPassword", data);
                startActivity(intent);
            }else {
                dl1.setVisibility(View.GONE);
                Toast.makeText(this,"登陆失败",Toast.LENGTH_SHORT).show();
                dl1.setVisibility(View.GONE);
            }
        });
        if(isFinishing()){
            mediaPlayer.stop();
        }
        }
        @Override
        protected void onRestart()
        {
            Log.d(TAG, "执行onRestart" );
            super.onRestart();
        }
        @Override
        protected void onResume(){
            Log.d(TAG, "执行onResume" );
            super.onResume();
        }
        @Override
        protected void onStart(){
        Log.d(TAG, "执行onStart" );
        super.onStart();
        }
        @Override
        protected void onPause(){
        Log.d(TAG, "执行onPause" );
        super.onPause();
        }
        @Override
        protected void onStop() {
          Log.d(TAG, "执行onStop" );
          super.onStop();
        }
        @Override
        protected void onDestroy(){
            Log.d(TAG, "执行onDestroy" );
            mediaPlayer.stop();
            mediaPlayer1.stop();
           super.onDestroy();
        }
        protected void onSaveInstanceState(Bundle outdate){
            super.onSaveInstanceState(outdate);
            EditText et1 = findViewById(R.id.text11);
            String tempData = et1.getText().toString();
             outdate.putString("data_key",tempData);
        }
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }
    public void onBackPressed() {
        Log.d(TAG, "执行onBackPressed" );
        mediaPlayer.pause();
        mediaPlayer1.pause();
        finish();
    }
    public boolean onOptionsItemSelected(MenuItem item){
        EditText et1 = findViewById(R.id.text11);
        EditText ed2 = findViewById(R.id.text22);
        String s1 = et1.getText().toString();
        String s2 = ed2.getText().toString();
        switch (item.getItemId()){
            case R.id.add_item1:
                if(s1.equals("12345") && s2.equals("12345")) {
                    Toast.makeText(this, "打电话给妈妈", Toast.LENGTH_SHORT).show();
                    Intent intent1 = new Intent(Intent.ACTION_DIAL);
                    intent1.setData(Uri.parse("tel:13421638547"));
                    startActivity(intent1);
                    finish();
                    break;
                }else{
                    Toast.makeText(this, "你没有权限访问", Toast.LENGTH_SHORT).show();
                    break;
                }
            case R.id.add_item2:
                if(s1.equals("12345") && s2.equals("12345")){
                    Toast.makeText(this,"打电话给爸爸",Toast.LENGTH_SHORT).show();
                    Intent intent2 = new Intent(Intent.ACTION_DIAL);
                    intent2.setData(Uri.parse("tel:13646557909"));
                    startActivity(intent2);
                    finish();break;
                }else{
                    Toast.makeText(this, "你没有权限访问", Toast.LENGTH_SHORT).show();
                    break;
                }
            case R.id.add_item4gs:
                Toast.makeText(this,"学习愉快呀",Toast.LENGTH_SHORT).show();
                Intent intent4 = new Intent(Intent.ACTION_VIEW);
                intent4.setData(Uri.parse("https://www.bilibili.com/video/BV1Eb411u7Fw?spm_id_from=333.999.0.0"));
                startActivity(intent4);break;
            case R.id.add_item3xd:
                Toast.makeText(this,"学习愉快呀",Toast.LENGTH_SHORT).show();
                Intent intent3 = new Intent(MainFirstActivity.this,ThirdActivity.class);
                startActivity(intent3);break;
            default:
        }
        return true;
    }
}