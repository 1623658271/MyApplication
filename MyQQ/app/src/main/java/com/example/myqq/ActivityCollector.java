package com.example.myqq;

import android.app.Activity;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class ActivityCollector {

    public static List<Activity> activities=new ArrayList<>();

    //添加活动
    public static void addActivity(Activity activity){
        activities.add(activity);
    }

    //从返回栈中移除活动
    public static void removeActivity(Activity activity){
        activities.remove(activity);
    }

    //销毁全部活动
    public static void finishAll(){
        Log.d("data", "finishAll: ");
        for(Activity activity:activities){
            if(!activity.isFinishing()){
                activity.finish();
            }
        }
        activities.clear();
    }
}
