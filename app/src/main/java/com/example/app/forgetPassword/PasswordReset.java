package com.example.app.forgetPassword;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app.R;

public class PasswordReset extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_reset);

    }

    public void verifyButton(View view)
    {
        Intent intent=new Intent(getApplicationContext(), com.example.app.forgetPassword.SetPassword.class);
        startActivity(intent);
        finish();
    }
}