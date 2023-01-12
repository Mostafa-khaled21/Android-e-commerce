package com.example.e_com.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.e_com.Data.RemoteData.Product;
import com.example.e_com.Data.RemoteData.ProductModel;
import com.example.e_com.R;
import com.example.e_com.UI.detaills;
import com.example.e_com.UI.fav;

import java.util.ArrayList;
import java.util.List;

public class productAdapter extends RecyclerView.Adapter<productAdapter.MyViewHolder> {
    Context context;
    ProductModel data;
  //  List<ProductModel> productListAll;
  //    int y=0;
    public productAdapter(Context context, ProductModel data) {
        this.context = context;
        this.data = data;
     //   this.productListAll= (List<ProductModel>) data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.product_cell,parent,false);

        return new MyViewHolder(v);
    }



    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            holder.title.setText(data.getProducts().get(position).getTitle());
            holder.cat.setText(data.getProducts().get(position).getCategory());
            holder.price.setText("$" + String.valueOf(data.getProducts().get(position).getPrice()));
            Glide.with(context)
                    .load(data.getProducts().get(position).getThumbnail())
                    .centerCrop()
                    .into(holder.img);

holder.itemView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent =new Intent(context,detaills.class);
        intent.putExtra("position",holder.getAdapterPosition());
        context.startActivity(intent);
    }
});

        holder.favo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle=new Bundle();
                bundle.putInt("pos",holder.getAdapterPosition());
                Intent  intent=new Intent(context, fav.class);
                intent.putExtras(bundle);
                context.startActivity(intent);

            }
        });



    }

    @Override
    public int getItemCount() {
//        for (int i=0;i<data.getProducts().size();i++){
//            if(Integer.valueOf(data.getProducts().get(i).getPrice())<900){
//                x++;
//            }
//        }
//
//        return x;
        return data.getProducts().size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder{
ImageView img;
TextView title, cat,price;
        CardView card;
        Button favo;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.product_title);
            cat=itemView.findViewById(R.id.product_desc);
            price=itemView.findViewById(R.id.product_price);
            img= itemView.findViewById(R.id.product_img);
            card=itemView.findViewById(R.id.card);
            favo=itemView.findViewById(R.id.product_btn);


        }
    }
}
