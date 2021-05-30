package com.example.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewTreeViewModelKt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MyAccount extends AppCompatActivity {

    FloatingActionButton floatingActionButton;
    RelativeLayout powerPage,cartPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);

        floatingActionButton = findViewById(R.id.floating_btn);
        powerPage=findViewById(R.id.powerPage);
        cartPage=findViewById(R.id.cartPage);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), EditProfile.class));
            }
        });

        cartPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),cartactivity.class));
            }
        });



    }

    public void mainPage(View view)
    {
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
    }

}