package com.example.e_com.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.e_com.R;

public class checkout extends AppCompatActivity {
Button back,placeorder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        back = findViewById(R.id.back_check);
        placeorder =findViewById(R.id.placeOrder);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        placeorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(checkout.this,orderAccepted.class);
                startActivity(intent);
            }
        });

    }
}