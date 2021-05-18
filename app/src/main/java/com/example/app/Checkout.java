package com.example.app;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


public class Checkout extends AppCompatActivity {

    private View view1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view1 = getLayoutInflater().inflate(R.layout.activity_checkout, null);
        setContentView(view1);
    }
}
