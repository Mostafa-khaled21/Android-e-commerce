package com.example.e_com.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.e_com.R;

public class start extends AppCompatActivity {
Button btnn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        btnn=findViewById(R.id.btn_sta);
        Intent intent=new Intent(start.this,numphone.class);

//        Intent inten=new Intent(start.this,numphone.class);
//
//        startActivity(inten);
        btnn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
startActivity(intent);
            }
        });
    }
}