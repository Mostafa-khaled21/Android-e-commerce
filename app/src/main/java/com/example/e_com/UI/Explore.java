package com.example.e_com.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.e_com.Adapter.productA;
import com.example.e_com.Adapter.productExplore;
import com.example.e_com.Data.LocalData.productM;
import com.example.e_com.R;

import java.util.ArrayList;

public class Explore extends AppCompatActivity {
    int [] img_rec_EXP={R.drawable.e1,R.drawable.e2,R.drawable.e3,R.drawable.e4,R.drawable.e5,R.drawable.e6};
    String [] name_rec_EXP={"Frash Fruits and Vegetable","Cooking Oil and Ghee","Meat and Fish","Bakery and snacks"
    ,"Dairy and Eggs","Beverages"};
    String[] color ={"#53B175","#F8A44C","#F7A593","#D3B0E0","#FDE598","#B7DFF5"};
    RecyclerView rec;
    ArrayList<productM> productEXP=new ArrayList<>();
    Button fav,cart,acc,shop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore);
        rec=findViewById(R.id.recycle_exp);
        fav =findViewById(R.id.fav);
        shop =findViewById(R.id.shop);
        acc =findViewById(R.id.acc);
        cart=findViewById(R.id.cart);
//        shop.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(Explore.this,homeScreen.class);
//                startActivity(intent);
//            }
//        });
//        acc.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(Explore.this,account.class);
//                startActivity(intent);
//            }
//        });
//
//        cart.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(Explore.this,Cart.class);
//                startActivity(intent);
//            }
//        });
//        fav.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i=new Intent(Explore.this,fav.class);
//                startActivity(i);
//            }
//        });

        productExplore adapter=new productExplore(this,productEXP);
        setProductModels3();
        rec.setAdapter(adapter);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
        rec.setLayoutManager(staggeredGridLayoutManager);

    }
    private  void setProductModels3(){
        for (int i=0;i< name_rec_EXP.length;i++){
            productEXP.add(new productM(
                    name_rec_EXP[i],
                    img_rec_EXP[i],
                    color[i]));

        }
    }
}