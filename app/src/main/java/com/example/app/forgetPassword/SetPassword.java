package com.example.app.forgetPassword;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app.R;

public class SetPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_password);
    }

    public void callPasswordUpdatedPage(View view)
    {

        startActivity(new Intent(getApplicationContext(),SuccessMessage.class));
        finish();
    }
}