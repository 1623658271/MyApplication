package com.example.redrock;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import java.util.ArrayList;

public class FirstActivity extends AppCompatActivity {

    private ArrayList<Fragment> data = new ArrayList<>();
    private ViewPager2 viewPager2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);

        viewPager2 = findViewById(R.id.view_pager);
        data.add(new Fragment1());
        data.add(new Fragment2());
        data.add(new Fragment3());
        FragmentStateAdapter adapter = new FragmentAdapter(this,data);
        viewPager2.setAdapter(adapter);
    }
}