package com.example.e_com.UI;

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

public class fav extends AppCompatActivity {
    Button explore,cart,acc,shop;
    RecyclerView rec;
    int x,count;
    productCart adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav);
        rec=findViewById(R.id.rec_fav);
        explore =findViewById(R.id.explore);
        shop =findViewById(R.id.shop);
        acc =findViewById(R.id.acc);
        cart=findViewById(R.id.cart);
        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(fav.this,homeScreen.class);
                startActivity(intent);
            }
        });
        acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(fav.this,account.class);
                startActivity(intent);
            }
        });

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(fav.this,Cart.class);
                startActivity(intent);
            }
        });
        explore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(fav.this,Explore.class);
                startActivity(i);
            }
        });
        Bundle bundle = getIntent().getExtras();

        ProductViewModel productViewModel = new ViewModelProvider(this).get(ProductViewModel.class);
        productViewModel.getProduct().observe(this, new Observer<ProductModel>() {
            @Override
            public void onChanged(ProductModel productModel) {
                x=bundle.getInt("pos");
                count=bundle.getInt("count");
                Log.d("answer", "cart3");

                adapter = new productCart(fav.this, productModel,x);
                rec.setAdapter(adapter);
                Log.d("answer", "cart4");

                rec.setLayoutManager(new LinearLayoutManager(fav.this, LinearLayoutManager.VERTICAL, false));
                Log.d("answer", "cart5");
            }
        });

    }
}