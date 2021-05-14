package com.example.app.createAccount;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app.R;

public class SignUp2 extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up2);


    }
    public void verifyOTPButton(View view)
    {
        Intent intent=new Intent(getApplicationContext(), com.example.app.createAccount.VerifyOtp.class);
        startActivity(intent);
    }
}