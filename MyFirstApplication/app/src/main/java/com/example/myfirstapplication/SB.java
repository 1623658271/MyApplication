package com.example.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SB extends AppCompatActivity {
    private NotificationManager manager;
    private Notification notification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sb_activity);
        Intent intent = new Intent(this,MainFirstActivity.class);
        Intent intent2 = getIntent();
        String data = intent2.getStringExtra("inputPassword");
        TextView textView = findViewById(R.id.getInputPassword);
        textView.setText("你输入的密码是"+data);
        PendingIntent pendingIntent=PendingIntent.getActivity(this,0,intent,0);
        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notification = new NotificationCompat.Builder(this,"hello")
                    .setContentTitle("官方通知")
                    .setContentText("天空突然断了层刮起了风")
                    .setSmallIcon(R.drawable.ic_baseline_person_24)
                    .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.hz1))
                    .setColor(Color.parseColor("#ff0000"))
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true)
                    .build();
            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
                NotificationChannel channel = new NotificationChannel("hello","Hello",NotificationManager.IMPORTANCE_HIGH);
                manager.createNotificationChannel(channel);
        }
            sendNotification(textView);
    }
    public void sendNotification(View view){
        manager.notify(null,1,notification);
    }

    public void cancelNotification(View view){
        manager.cancel(1);
    }
}