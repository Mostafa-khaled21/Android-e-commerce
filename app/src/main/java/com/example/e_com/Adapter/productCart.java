package com.example.e_com.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.e_com.Data.RemoteData.ProductModel;
import com.example.e_com.R;
import com.example.e_com.UI.detaills;

import java.util.List;

public class productCart extends RecyclerView.Adapter<productCart.ViewHodler> {
    Context context;
   // String[] arr_title,arr_price,arr_img;
    ProductModel data;
    int x,count;

    public productCart(Context context, ProductModel data, int x) {
        this.context = context;
        this.data = data;
        this.x = x;
        this.count=count;
    }
    //   LiveData<List<String>> arr_title,arr_price,arr_img;

//    public productCart(Context context, LiveData<List<String>> array_title, LiveData<List<String>> array_price, LiveData<List<String>> array_img) {
//        this.context = context;
//        this.arr_title = array_title;
//        this.arr_price = array_price;
//        this.arr_img = array_img;
//    }
//    public productCart(Context context, List<String> array_title, List<String> array_price, List<String> array_img) {
//        this.context = context;
//        this.arr_title = array_title;
//        this.arr_price = array_price;
//        this.arr_img = array_img;
//    }


//    public productCart(Context context, String[] arr_title, String[] arr_price, String[] arr_img) {
//        this.context = context;
//        this.arr_title = arr_title;
//        this.arr_price = arr_price;
//        this.arr_img = arr_img;
//    }

    @NonNull
    @Override
    public ViewHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.rec_cart,parent,false);

        return new ViewHodler(v);    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodler holder, int position) {


            holder.title.setText(data.getProducts().get(x).getTitle());
            holder.price.setText("$ " + data.getProducts().get(x).getPrice());
            Glide.with(context)
                    .load(data.getProducts().get(x).getThumbnail())
                    .centerCrop()
                    .into(holder.img);


    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class ViewHodler extends RecyclerView.ViewHolder {
        ImageView img;
        TextView price ,title,count;
        Button in,des;
        public ViewHodler(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img_cart);
            title=itemView.findViewById(R.id.title_cart);
            price=itemView.findViewById(R.id.price1_cart);
        }
    }
}
