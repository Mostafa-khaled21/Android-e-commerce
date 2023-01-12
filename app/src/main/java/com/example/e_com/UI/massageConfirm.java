package com.example.e_com.UI;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.e_com.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class massageConfirm extends AppCompatActivity {
Button btn;
String number;
String code;
    FirebaseAuth mAuth;

//String verificationID;
EditText massage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_massage_confirm);
        btn=findViewById(R.id.massage_cont);
        massage=findViewById(R.id.edit_massage);
        Log.d("phone","on1");

        //Intent intent=new Intent(massageConfirm.this,location.class);
        Intent i = getIntent();

        Log.d("phone","on2");

        String verificationID=i.getStringExtra("verificationID");
        Log.d("phone","on3");


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("phone","on4");
                if (massage.getText().toString().isEmpty()){
                    Toast.makeText(massageConfirm.this, "please enter valid code", Toast.LENGTH_SHORT).show();
               return;
                }
                String code=massage.getText().toString();

                if (verificationID != null){
                    PhoneAuthCredential phoneAuthCredential =PhoneAuthProvider.getCredential(
                            verificationID,
                            code
                    );
                    FirebaseAuth.getInstance().signInWithCredential(phoneAuthCredential)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()){
                                        Intent intent=new Intent(massageConfirm.this,location.class);
                                        startActivity(intent);
                                    }else {
                                        Toast.makeText(massageConfirm.this, "the verification code entered was invalid", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });

                }





            }
        });
    }

}