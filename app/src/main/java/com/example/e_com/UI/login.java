package com.example.e_com.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.e_com.Data.RemoteData.Users;
import com.example.e_com.R;
import com.example.e_com.ViewModel.userViewModel;

public class login extends AppCompatActivity {
    EditText email,pass;
    TextView forget,signup;
    Button signIn;
    boolean x=true;
    int position1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email=findViewById(R.id.email_login);
        pass=findViewById(R.id.pass_login);
        forget=findViewById(R.id.forget_login);
        signup =findViewById(R.id.signup_login);
        signIn=findViewById(R.id.login);
        userViewModel userviewModel=new ViewModelProvider(this).get(userViewModel.class);
        userviewModel.getUsers().observe(this, new Observer<Users>() {
            @Override
            public void onChanged(Users users) {
                signIn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        for (int i=0;i<30;i++){
                            if (email.getText().toString().equalsIgnoreCase(users.getUsers().get(i).getEmail())&&
                            pass.getText().toString().equalsIgnoreCase(users.getUsers().get(i).getPassword())){
                                Log.d("answer","if");

                                Intent intent=new Intent(login.this,homeScreen.class);
                                position1 =i;
                                Intent ii=new Intent(login.this,account.class);
                                ii.putExtra("positionn",position1);

                       startActivity(intent);
                                Log.d("answer","if done");
                                x=false;

                                break;
                            }

                        }
                        if (x) {
                            Toast.makeText(login.this, "Wrong email or password", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
            }
        });

            signup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent =new Intent(login.this,reg.class);
                    startActivity(intent);

                }
            });

    }
}