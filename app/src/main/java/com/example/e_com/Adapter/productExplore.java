package com.example.e_com.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_com.Data.LocalData.productM;
import com.example.e_com.R;
import com.example.e_com.UI.Beverages;
import com.example.e_com.UI.Fruits;
import com.example.e_com.UI.bakery;
import com.example.e_com.UI.cookingoil;
import com.example.e_com.UI.dairy;
import com.example.e_com.UI.meat;

import java.util.ArrayList;

public class productExplore extends RecyclerView.Adapter<productExplore.viewHolder> {

    ArrayList<productM> data1;
    Context c;

    public productExplore(Context c, ArrayList<productM> data1) {
        this.data1 = data1;
        this.c = c;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vv= LayoutInflater.from(parent.getContext()).inflate(R.layout.rec_product,parent,false);
        return new viewHolder(vv);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.pro_name.setText(data1.get(position).getNamee());
     holder.pro_image.setImageResource(data1.get(position).getImgg());
     holder.itemView.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             if (holder.getAdapterPosition()==0){
                 Intent i=new Intent(c,Fruits.class);
                 c.startActivity(i);
             }else if (holder.getAdapterPosition()==1){
                 Intent i=new Intent(c,cookingoil.class);
                 c.startActivity(i);
             }else if (holder.getAdapterPosition()==2){
                 Intent i=new Intent(c,meat.class);
                 c.startActivity(i);
             }else if (holder.getAdapterPosition()==3){
                 Intent i=new Intent(c,bakery.class);
                 c.startActivity(i);
             }else if (holder.getAdapterPosition()==4){
                 Intent i=new Intent(c,dairy.class);
                 c.startActivity(i);
             }else if (holder.getAdapterPosition()==5){
                 Intent i=new Intent(c,Beverages.class);
                 c.startActivity(i);
             }
         }
     });
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
            this.pro_name=itemView.findViewById(R.id.text_rec_product1);
            this.pro_image=itemView.findViewById(R.id.img_rec_product1);
        }
    }
}
