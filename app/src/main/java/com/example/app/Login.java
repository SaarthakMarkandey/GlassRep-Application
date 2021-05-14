package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app.createAccount.SignUp1;
import com.example.app.forgetPassword.ForgetPassword;


public class Login extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    public void callForgetPasswordPage(View view)
    {
        Intent intent=new Intent(getApplicationContext(), ForgetPassword.class);
        startActivity(intent);
    }

    public void callSignUp1Page(View view)
    {
        Intent intent=new Intent(getApplicationContext(), SignUp1.class);
        startActivity(intent);
    }
}