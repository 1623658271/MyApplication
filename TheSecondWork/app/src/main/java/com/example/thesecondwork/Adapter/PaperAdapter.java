package com.example.thesecondwork.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thesecondwork.Activities.Bean;
import com.example.thesecondwork.R;

import java.util.ArrayList;

public class PaperAdapter extends RecyclerView.Adapter<PaperAdapter.InnerHolder> {

    private ArrayList<Bean> data;

    public PaperAdapter(ArrayList<Bean> data) {
        this.data = data;
    }

    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class InnerHolder extends RecyclerView.ViewHolder {
        private ImageView imageView1;
        private TextView textView1;
        public InnerHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new InnerHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_model,parent,false));
    }
}
