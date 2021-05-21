package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AddAddress extends AppCompatActivity {

    private Button add_to_saved;
    private Button saved_address;
    private ImageView back_add_address;

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_shipping);

        add_to_saved =(Button) findViewById(R.id.add_to_saved);
        add_to_saved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), SavedAddress.class);
                startActivity(intent);
                finish();
            }
        });

        saved_address =(Button) findViewById(R.id.saved_address);
        saved_address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(getApplicationContext(), SavedAddress.class);
                startActivity(intent);
                finish();
            }
        });

        back_add_address = (ImageView) findViewById(R.id.back_add_address);

        back_add_address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(getApplicationContext(), PaymentDetails.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
