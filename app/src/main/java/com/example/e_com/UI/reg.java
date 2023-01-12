package com.example.e_com.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.e_com.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class reg extends AppCompatActivity {
EditText user,email,pass;
TextView signin;
Button signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        user=findViewById(R.id.user_reg);
        email=findViewById(R.id.email_reg);
        pass=findViewById(R.id.pass_reg);
        signin=findViewById(R.id.signin_reg);
        signup=findViewById(R.id.signup);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(reg.this,login.class);
                startActivity(intent);
            }
        });
       signup.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent i=new Intent(reg.this,homeScreen.class);
               startActivity(i);
           }
       });
    }

}