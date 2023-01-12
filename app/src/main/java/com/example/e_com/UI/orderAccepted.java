package com.example.e_com.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.e_com.R;

public class orderAccepted extends AppCompatActivity {
    Button Back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oeder_accepted);
        Back=findViewById(R.id.backToHome);

        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(orderAccepted.this,homeScreen.class);
                startActivity(i);
                finish();
            }
        });

    }
}