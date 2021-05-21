package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class NetBankingActivity extends AppCompatActivity {

    private ImageView back_net_banking;
    private Button add_address_net_banking;

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net_banking);

        back_net_banking =(ImageView) findViewById(R.id.back_net_banking);
        back_net_banking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), PaymentDetails.class);
                startActivity(intent);
                finish();
            }
        });

        add_address_net_banking = (Button) findViewById(R.id.add_address_net_banking);
        add_address_net_banking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), AddAddress.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
