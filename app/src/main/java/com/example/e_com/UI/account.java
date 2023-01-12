package com.example.e_com.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.e_com.Data.RemoteData.Users;
import com.example.e_com.R;
import com.example.e_com.ViewModel.userViewModel;

public class account extends AppCompatActivity {
    Button logout;
    TextView name,email;
int x;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        logout=findViewById(R.id.logout1);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(account.this,start.class);
                startActivity(i);
                finish();
            }
        });


    }
}