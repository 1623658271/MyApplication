package com.example.myqq;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    private List<LearningClass> data;
    private  Context context;

    public MyAdapter(List<LearningClass> data,Context context){
        this.context=context;
        this.data=data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context,R.layout.study,null);
        return  new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv.setText(data.get(position).getWebName());
        holder.iv.setImageResource(data.get(position).getImageId());
    }

    @Override
    public int getItemCount() {
        return data == null?0:data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView tv;
        private ImageView iv;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.study_name);
            iv = itemView.findViewById(R.id.study_image);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(onRecyclerItemClickListener!=null){
                        onRecyclerItemClickListener.onRecyclerItemListen(getAdapterPosition());

                    }
                }
            });
        }
    }
    private  OnRecyclerItemClickListener onRecyclerItemClickListener;
    public void setOnRecyclerItemClickListener(OnRecyclerItemClickListener listener){
        onRecyclerItemClickListener  = listener;
    }
    public interface  OnRecyclerItemClickListener{
        void onRecyclerItemListen(int position);
    }
}
