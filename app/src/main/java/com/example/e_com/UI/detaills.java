package com.example.e_com.UI;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.example.e_com.Data.RemoteData.ProductModel;
import com.example.e_com.R;
import com.example.e_com.ViewModel.ProductViewModel;

import java.util.ArrayList;
import java.util.List;

public class detaills extends AppCompatActivity {
    TextView title,desc,count,price,rating,rev;
    ImageView img;
    Button add,in,des,back;
  //  private sql cart;
//    public static LiveData<List<String>> array_title,array_price,array_img;
  int y=1;
    public static List<String> array_title,array_price,array_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detaills);

        title=findViewById(R.id.titlee);
        rev=findViewById(R.id.rev);
        back=findViewById(R.id.back);
        desc=findViewById(R.id.descr);
        count=findViewById(R.id.count);
        price=findViewById(R.id.price);
        rating=findViewById(R.id.rating);
        img=findViewById(R.id.img);
        add=findViewById(R.id.add);
        in=findViewById(R.id.incr);
        des=findViewById(R.id.dec);
        array_title=new ArrayList<>();
        array_price=new ArrayList<>();
        array_img=new ArrayList<>();
      //  cart =new sql(detaills.this);
        Intent intent = getIntent();
        int position = intent.getIntExtra("position",1);

        ProductViewModel productViewModel=new ViewModelProvider(this).get(ProductViewModel.class);
        productViewModel.getProduct().observe(this, new Observer<ProductModel>() {
            @Override
            public void onChanged(ProductModel productModel) {
                title.setText(productModel.getProducts().get(position).getTitle());

                desc.setText(productModel.getProducts().get(position).getDescription());

                price.setText("$" + String.valueOf(productModel.getProducts().get(position).getPrice()));
                Glide.with(detaills.this)
                        .load(productModel.getProducts().get(position).getThumbnail())
                        .centerCrop()
                        .into(img);
                add.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
//                        cart.addContact(productModel.getProducts().get(position).getTitle(),productModel.getProducts().get(position).getThumbnail()
//                                ,String.valueOf(productModel.getProducts().get(position).getPrice()));
                        array_title.add(productModel.getProducts().get(position).getTitle());
                        array_price.add(String.valueOf(productModel.getProducts().get(position).getPrice()));
                        array_img.add(productModel.getProducts().get(position).getThumbnail());
                        Log.d("answer",productModel.getProducts().get(position).getTitle());
                        Log.d("answer",productModel.getProducts().get(position).getThumbnail());
                        Log.d("answer", String.valueOf(productModel.getProducts().get(position).getPrice()));

                        Bundle bundle=new Bundle();
                    //    bundle.putString("title",productModel.getProducts().get(position).getTitle());
                    //    bundle.putString("price", String.valueOf(productModel.getProducts().get(position).getPrice()));
                    //    bundle.putString("img",productModel.getProducts().get(position).getThumbnail());
                        bundle.putInt("x",position);
                        bundle.putInt("count", Integer.parseInt(count.getText().toString()));
                        Log.d("answer", String.valueOf(y));
                        bundle.putInt("y",y);
                       Intent  intent=new Intent(detaills.this,Cart.class);
                        intent.putExtras(bundle);
                        startActivity(intent);
                        y++;
                        Log.d("answer", String.valueOf(y));

                    }
                });
            }
        });

        in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count.setText(""+(Integer.valueOf(count.getText().toString())+1));
            }
        });
        des.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Integer.valueOf(count.getText().toString())==0){
                    Toast.makeText(detaills.this, "error", Toast.LENGTH_SHORT).show();
                }else{

                    count.setText(""+(Integer.valueOf(count.getText().toString())-1));

                }
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