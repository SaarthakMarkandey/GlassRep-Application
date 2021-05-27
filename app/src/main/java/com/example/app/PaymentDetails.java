package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;


public class PaymentDetails extends AppCompatActivity {

    private ImageView back_payment;
    private RadioButton upi_btn;
    private RadioButton paytm_btn;
    private RadioButton net_banking_btn;
    private RadioButton cod_btn;
    private RadioButton credit_card_btn;
    private Button proceed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_details);

        back_payment =(ImageView) findViewById(R.id.back_payment);
        back_payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), Power.class);
                startActivity(intent);
                finish();
            }
        });

        upi_btn = (RadioButton) findViewById(R.id.upi_btn);
        paytm_btn = (RadioButton) findViewById(R.id.paytm_btn);
        net_banking_btn = (RadioButton) findViewById(R.id.net_banking_btn);
        cod_btn = (RadioButton) findViewById(R.id.cod_btn);
        credit_card_btn = (RadioButton) findViewById(R.id.credit_card_btn);
        proceed = (Button) findViewById(R.id.proceed);

        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(upi_btn.isChecked()){
                    Intent intent=new Intent(getApplicationContext(), UPIActivity.class);
                    startActivity(intent);
                    finish();
                }else if(paytm_btn.isChecked()){
                    Intent intent=new Intent(getApplicationContext(), PaytmActivity.class);
                    startActivity(intent);
                    finish();
                }else if(net_banking_btn.isChecked()){
                    Intent intent=new Intent(getApplicationContext(), NetBankingActivity.class);
                    startActivity(intent);
                    finish();
                }else if(credit_card_btn.isChecked()){
                    Intent intent=new Intent(getApplicationContext(), AddAddress.class);
                    startActivity(intent);
                    finish();
                }else if(cod_btn.isChecked()){
                    Intent intent=new Intent(getApplicationContext(), AddAddress.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

    }
}
