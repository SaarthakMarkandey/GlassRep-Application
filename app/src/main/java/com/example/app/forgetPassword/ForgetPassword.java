package com.example.app.forgetPassword;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app.Login;
import com.example.app.R;

public class ForgetPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

    }


    public void callSetPasswordPage(View view) {
        Intent intent = new Intent(getApplicationContext(), PasswordReset.class);
        startActivity(intent);
    }

    public void callLogin2(View view)
    {

        Intent intent = new Intent(getApplicationContext(), Login.class);

        startActivity(intent);
    }
}