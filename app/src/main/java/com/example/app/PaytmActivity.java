package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PaytmActivity extends AppCompatActivity {

    private ImageView back_paytm;
    private Button add_address_paytm;

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paytm);

        back_paytm =(ImageView) findViewById(R.id.back_paytm);
        back_paytm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), PaymentDetails.class);
                startActivity(intent);
                finish();
            }
        });

        add_address_paytm = (Button) findViewById(R.id.add_address_paytm);
        add_address_paytm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), AddAddress.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
