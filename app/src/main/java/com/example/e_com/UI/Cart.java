package com.example.e_com.UI;

import static com.example.e_com.UI.detaills.array_img;
import static com.example.e_com.UI.detaills.array_price;
import static com.example.e_com.UI.detaills.array_title;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.e_com.Adapter.productCart;
import com.example.e_com.Data.RemoteData.ProductModel;
import com.example.e_com.R;
import com.example.e_com.ViewModel.ProductViewModel;

import java.util.List;

public class Cart extends AppCompatActivity {
RecyclerView rec;
String[] title;
    String[] img;
    String[] price;
    int x,count;
           productCart adapter ;
    Button explore,fav,acc,shop,checkout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        rec=findViewById(R.id.rec_cart);

        explore =findViewById(R.id.explore);
        shop =findViewById(R.id.shop);
        acc =findViewById(R.id.acc);
        fav=findViewById(R.id.fav);
        checkout=findViewById(R.id.checkout);
        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Cart.this, checkout.class);
                startActivity(intent);
            }
        });
        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Cart.this,homeScreen.class);
                startActivity(intent);
            }
        });
        acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Cart.this,account.class);
                startActivity(intent);
            }
        });

        fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Cart.this,fav.class);
                startActivity(intent);
            }
        });
        explore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Cart.this,Explore.class);
                startActivity(i);
            }
        });

        Bundle bundle = getIntent().getExtras();

            ProductViewModel productViewModel = new ViewModelProvider(this).get(ProductViewModel.class);
            productViewModel.getProduct().observe(this, new Observer<ProductModel>() {
                @Override
                public void onChanged(ProductModel productModel) {
                    x=bundle.getInt("x");
                    count=bundle.getInt("count");

                    Log.d("answer", "cart3");

                    adapter = new productCart(Cart.this, productModel, x);
                    rec.setAdapter(adapter);
                    Log.d("answer", "cart4");

                    rec.setLayoutManager(new LinearLayoutManager(Cart.this, LinearLayoutManager.VERTICAL, false));
                    Log.d("answer", "cart5");
                }
            });
        }


    }
