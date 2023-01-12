package com.example.e_com.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_com.Data.LocalData.productM;
import com.example.e_com.R;

import java.util.ArrayList;

public class productA extends RecyclerView.Adapter<productA.viewHolder> {

    ArrayList<productM> data1;
    Context c;

    public productA(Context c, ArrayList<productM> data1) {
        this.data1 = data1;
        this.c = c;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vv= LayoutInflater.from(parent.getContext()).inflate(R.layout.rec,parent,false);
        return new viewHolder(vv);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.pro_name.setText(data1.get(position).getNamee());
     holder.pro_image.setImageResource(data1.get(position).getImgg());
    }

    @Override
    public int getItemCount() {
        return data1.size();
    }


    public class viewHolder extends RecyclerView.ViewHolder{
        public TextView pro_name;
        public ImageView pro_image;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            this.pro_name=itemView.findViewById(R.id.text_rec2);
            this.pro_image=itemView.findViewById(R.id.img_rec2);
        }
    }
}
