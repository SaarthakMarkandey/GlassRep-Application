package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class UPIActivity extends AppCompatActivity {

    private ImageView back_upi;
    private Button add_address_upi;

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upi);


        back_upi =(ImageView) findViewById(R.id.back_upi);
        back_upi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), PaymentDetails.class);
                startActivity(intent);
                finish();
            }
        });

        add_address_upi = (Button) findViewById(R.id.add_address_upi);
        add_address_upi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), AddAddress.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
