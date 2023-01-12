package com.example.e_com.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.e_com.Adapter.productA;
import com.example.e_com.Adapter.productAdapter;
import com.example.e_com.Data.LocalData.productM;
import com.example.e_com.Data.RemoteData.ProductModel;
import com.example.e_com.R;
import com.example.e_com.ViewModel.ProductViewModel;
import com.example.e_com.ViewModel.viewMo;

import java.util.ArrayList;
import java.util.List;

public class homeScreen extends AppCompatActivity {
    int [] img_rec3={R.drawable.pulses,R.drawable.rice};
    String [] name_rec3={"Pulses","Rice"};
    RecyclerView rec1,rec2,rec3,rec4;
    Button explore,cart,fav,acc;
    CardView card;
    ArrayList<productM> productMM=new ArrayList<>();
    productAdapter adapterr;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        rec1 = findViewById(R.id.recycle1);
        rec2 = findViewById(R.id.recycle2);
        rec3 = findViewById(R.id.recycle3);
        rec4 = findViewById(R.id.recycle4);
        explore =findViewById(R.id.explore);
        fav =findViewById(R.id.fav);
        acc =findViewById(R.id.acc);
        cart=findViewById(R.id.cart);
        searchView=findViewById(R.id.search);

        fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(homeScreen.this,fav.class);
                startActivity(intent);

            }
        });
        acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(homeScreen.this,account.class);
                startActivity(intent);
            }
        });

cart.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
       Intent intent=new Intent(homeScreen.this,Cart.class);
       startActivity(intent);
    }
});
        explore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(homeScreen.this,Explore.class);
                startActivity(i);
            }
        });




        productA adapter=new productA(this,productMM);
        setProductModels3();
        rec3.setAdapter(adapter);
        rec3.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));



ProductViewModel productViewModel=new ViewModelProvider(this).get(ProductViewModel.class);
productViewModel.getProduct().observe(this, new Observer<ProductModel>() {
    @Override
    public void onChanged(ProductModel productModel) {
        adapterr =new productAdapter(homeScreen.this,productModel);
        rec1.setAdapter(adapterr);
        rec1.setLayoutManager(new LinearLayoutManager(homeScreen.this,LinearLayoutManager.HORIZONTAL,false));
     rec2.setAdapter(adapterr);
        rec2.setLayoutManager(new LinearLayoutManager(homeScreen.this,LinearLayoutManager.HORIZONTAL,false));
     rec4.setAdapter(adapterr);
        rec4.setLayoutManager(new LinearLayoutManager(homeScreen.this,LinearLayoutManager.HORIZONTAL,false));
    }
});





    }
    private  void setProductModels3(){
        for (int i=0;i< name_rec3.length;i++){
            productMM.add(new productM(
                    name_rec3[i],
                    img_rec3[i]));

        }
    }
}