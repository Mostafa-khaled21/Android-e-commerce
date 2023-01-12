package com.example.e_com.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.e_com.Adapter.productAdapter;
import com.example.e_com.Data.RemoteData.ProductModel;
import com.example.e_com.R;
import com.example.e_com.ViewModel.ProductViewModel;

public class Fruits extends AppCompatActivity {
RecyclerView rec;
    productAdapter adapter;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruits);
        rec=findViewById(R.id.rec_fru);
        back=findViewById(R.id.back);

        ProductViewModel productViewModel=new ViewModelProvider(this).get(ProductViewModel.class);
        productViewModel.getProduct().observe(this, new Observer<ProductModel>() {
            @Override
            public void onChanged(ProductModel productModel) {
                adapter =new productAdapter(Fruits.this,productModel);
                rec.setAdapter(adapter);
                StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
                rec.setLayoutManager(staggeredGridLayoutManager);

            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}