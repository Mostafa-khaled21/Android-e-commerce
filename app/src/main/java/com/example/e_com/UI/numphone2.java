package com.example.e_com.UI;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.e_com.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class numphone2 extends AppCompatActivity {
Button btn1;
EditText num;
FirebaseAuth mAuth;
String verificationID;
    PhoneAuthProvider phoneAuthProvider;
    String code;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numphone2);
        btn1=findViewById(R.id.numphone2_cont);
        num=findViewById(R.id.num_edit1);


        Intent intent=new Intent(numphone2.this,massageConfirm.class);
        mAuth=FirebaseAuth.getInstance();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(num.getText().toString())){
                    Toast.makeText(numphone2.this, "Enter valid phone No.", Toast.LENGTH_SHORT).show();

                }else {
//
////                    number="+2"+num.getText().toString();
////                    Toast.makeText(numphone2.this, ""+number,Toast.LENGTH_SHORT).show();
////                    // sendverificationcode(number);
////                    //    verificode(code);
////                    intent.putExtra("number",number);
////                    intent.putExtra("num",num.getText().toString());
////                    Log.d("phone","finish");
////                    startActivity(intent);
////                    Log.d("phone","finish1");
////
//                    String number="+2"+num.getText().toString();
//                    Toast.makeText(numphone2.this, ""+number,Toast.LENGTH_SHORT).show();
////                    sendverificationcode(number);
//
//
//
//                    intent.putExtra("verificationID",verificationID);
//
//                    intent.putExtra("num",code);
//                    startActivity(intent);
//                    PhoneAuthProvider.getInstance().verifyPhoneNumber(
//                            "+2"+num.getText().toString(),
//                            60,
//                            TimeUnit.SECONDS,
//                            numphone2.this,
//                            new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
//                                @Override
//                                public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
//
//                                }
//
//                                @Override
//                                public void onVerificationFailed(@NonNull FirebaseException e) {
//
//                                }
//                                 @Override
//               public void onCodeSent(@NonNull String verificationId,
//                   @NonNull PhoneAuthProvider.ForceResendingToken token) {
//                 super.onCodeSent(verificationId,token);
//                Log.d("phone","3");
//
//            verificationID =verificationId;
//            intent.putExtra("verificationID",verificationID);
//            startActivity(intent);
//
//        }
//                            }
//                    );

                    PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(mAuth)
                        .setPhoneNumber("+2"+num.getText().toString())       // Phone number to verify
                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                        .setActivity(numphone2.this)                 // Activity (for callback binding)
                        .setCallbacks(new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                            @Override
                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {

                            }

                            @Override
                            public void onVerificationFailed(@NonNull FirebaseException e) {
                                Toast.makeText(numphone2.this, "try again :"+e.getMessage(), Toast.LENGTH_SHORT).show();

                            }
                            public void onCodeSent(@NonNull String verificationId,
                                                   @NonNull PhoneAuthProvider.ForceResendingToken token) {
                                super.onCodeSent(verificationId,token);
                                Log.d("phone","3");

                                verificationID =verificationId;
                                intent.putExtra("verificationID",verificationID);
                                startActivity(intent);

                            }

                        })
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);

                }
            }

           
        });

    }

}