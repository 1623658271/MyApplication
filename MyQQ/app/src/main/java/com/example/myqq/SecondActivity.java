package com.example.myqq;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    private List<LearningClass> learningClasses = new ArrayList<>();
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //设置内容视图
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        getSupportActionBar().hide();

        RecyclerView rc = findViewById(R.id.rc_view);
        MyAdapter myAdapter = new MyAdapter(learningClasses,this);

        initLearn();

        rc.setAdapter(myAdapter);
        rc.setLayoutManager(new GridLayoutManager(this,2));
        rc.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        myAdapter.setOnRecyclerItemClickListener(new MyAdapter.OnRecyclerItemClickListener() {
            @Override
            public void onRecyclerItemListen(int position) {
                Toast.makeText(SecondActivity.this, learningClasses.get(position).getWebName(), Toast.LENGTH_SHORT).show();
            }
        });

        mediaPlayer = MediaPlayer.create(SecondActivity.this,R.raw.liuxingyu);
        mediaPlayer.start();

        //TextView控件
        TextView getUserName = findViewById(R.id.getUserName);
        TextView getPassWord = findViewById(R.id.getPassWord);

        //Button控件
        Button bt = findViewById(R.id.btText);
        Button btMusic = findViewById(R.id.music);
        btMusic.setOnClickListener(this);

        //获取用户名和密码
        Intent itGet = getIntent();
        String data1 = itGet.getStringExtra("data1");
        String data2 = itGet.getStringExtra("data2");

        getUserName.setText(data1);
        getPassWord.setText(data2);
    }

    private void initLearn() {
        for (int i = 1; i <= 10; i++) {
            LearningClass math1 = new LearningClass("高数" + i, R.mipmap.study);
            LearningClass math2 = new LearningClass("线代" + i, R.mipmap.study);
            learningClasses.add(math1);
            learningClasses.add(math2);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.music:
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                }else {
                    mediaPlayer.start();
                }
                break;
            default:
                break;
        }
    }

    public static void actionStart(Context context, String data1, String data2){
        Log.d("data", "actionStart: ");
        Intent intent = new Intent(context, SecondActivity.class);
        intent.putExtra("data1",data1);
        intent.putExtra("data2",data2);
        context.startActivity(intent);
    }
    protected void onDestroy(){
        super.onDestroy();
        mediaPlayer.pause();
    }

}