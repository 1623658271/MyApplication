package com.example.thesecondwork.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thesecondwork.Activities.Bean;
import com.example.thesecondwork.Adapter.FragmentPaperAdapter;
import com.example.thesecondwork.Adapter.PaperAdapter;
import com.example.thesecondwork.R;

import java.util.ArrayList;

public class Fragment1 extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<Bean> data = new ArrayList<>();
    private PaperAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment1,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.rv);

        for(int i=0;i<10;i++){
            Bean bean =new Bean("123",R.drawable.ic_launcher_background);
            data.add(bean);
        }
        adapter = new PaperAdapter(data);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
    }
}
