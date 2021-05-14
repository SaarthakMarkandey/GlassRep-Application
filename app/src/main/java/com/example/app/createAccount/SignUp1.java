package com.example.app.createAccount;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app.R;

public class SignUp1 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up1);


    }

    public void callSignUp2Page(View view)
    {

        Intent intent = new Intent(getApplicationContext(), SignUp2.class);

        startActivity(intent);
    }



}