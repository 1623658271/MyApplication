package com.example.thesecondwork.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.thesecondwork.Fragment.Fragment1;
import com.example.thesecondwork.Fragment.Fragment2;
import com.example.thesecondwork.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.PrimitiveIterator;

import com.example.thesecondwork.Adapter.FragmentPaperAdapter;
import com.example.thesecondwork.Adapter.PaperAdapter;

public class FirstActivity extends AppCompatActivity {

    private final ArrayList<String> data1 = new ArrayList<>();
    private final ArrayList<Integer> data2 = new ArrayList<>();
    private ViewPager2 viewPager2;
    private TabLayout tabLayout1;
    private final ArrayList<Fragment> fragments = new ArrayList<>();
    private FragmentPaperAdapter adapter2;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private static final String TAG = "data";
    private NotificationManager notificationManager;
    private Notification notification;
    private Intent intent;
    private PendingIntent pendingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        iniView();
        iniData();
        iniAdapter();
        iniEvent();
    }

    private void iniEvent() {
        intent.setData(Uri.parse("https://www.bilibili.com/read/cv10203737/"));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel("ntf",
                    "作业通知", NotificationManager.IMPORTANCE_HIGH);
            notificationManager.createNotificationChannel(notificationChannel);
        }
        notification = new NotificationCompat.Builder(this, "ntf")
                .setSmallIcon(R.drawable.ic_username)
                .setColor(Color.parseColor("#FF0000"))
                .setContentTitle("作业通知")
                .setContentText("快去做英语作业！")
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.number5))
                .build();
        notificationManager.cancel(1);
        notificationManager.notify(1, notification);
    }

    private void iniAdapter() {
        viewPager2.setAdapter(adapter2);
        new TabLayoutMediator(tabLayout1,viewPager2, (tab, position) -> {
            tab.setText(data1.get(position));
            tab.setIcon(R.drawable.selector_button);
        }).attach();
    }

    private void iniData() {
        data1.add("周一");
        data1.add("周二");
        data1.add("周三");
        data1.add("周四");
        data1.add("周五");
        data1.add("周六");
        data1.add("周日");
        for(int i=0;i<7;i++) {
            fragments.add(new Fragment1());
        }
    }
    private void iniView() {
        intent = new Intent(Intent.ACTION_VIEW);
        pendingIntent = PendingIntent.getActivity(this,0,intent,0);
        viewPager2 = findViewById(R.id.view_paper2);
        tabLayout1 = findViewById(R.id.tab_layout);
        adapter2 = new FragmentPaperAdapter(this,fragments);
        notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
    }
    public static void FirstActivityStart(Context context,String data1,String data2){
        Log.d(TAG, "FirstActivityStart: ");
        Intent intent = new Intent(context,FirstActivity.class);
        intent.putExtra("putUsername",data1);
        intent.putExtra("putPassword",data2);
        context.startActivity(intent);
    }
}