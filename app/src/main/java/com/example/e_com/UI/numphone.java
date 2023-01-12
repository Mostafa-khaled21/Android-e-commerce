package com.example.e_com.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
//
//import com.facebook.FacebookSdk;
//import com.facebook.appevents.AppEventsLogger;

import android.view.View;
import android.widget.EditText;

import com.example.e_com.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class numphone extends AppCompatActivity {
EditText num;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numphone);
        num=findViewById(R.id.num_numphone);

        DatabaseReference reference= FirebaseDatabase.getInstance().getReference("mmm").child("name");
        reference.setValue("mostafa");
        num.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(numphone.this,numphone2.class);
                startActivity(intent);
            }
        });



    }
}