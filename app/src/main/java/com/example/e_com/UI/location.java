package com.example.e_com.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import com.example.e_com.R;

public class location extends AppCompatActivity {
    Button sub;
String[] arr= {"ALEX","CAIRO","MANSOURA"};
String[] arr1= {"borg el arab"};
AutoCompleteTextView loc,loc1;
ArrayAdapter<String> adapter,adapter1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        loc=findViewById(R.id.location);
        loc1=findViewById(R.id.location1);
        adapter =new ArrayAdapter<String>(this,R.layout.list_item,arr);
        loc.setAdapter(adapter);
       adapter1 =new ArrayAdapter<String>(this,R.layout.list_item,arr1);
        loc1.setAdapter(adapter1);
        sub=findViewById(R.id.submit_loc);
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(location.this,login.class);
                startActivity(intent);
            }
        });


    }
}