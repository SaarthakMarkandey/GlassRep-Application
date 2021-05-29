package com.example.app;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.button.MaterialButton;

import java.io.Serializable;
import java.util.ArrayList;

public class PowerActivity extends AppCompatActivity {
    private MaterialButton materialButton;
    private ArrayList<Affirmation>affirmations;
    private ImageView backimg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_power);
//        Intent intent2=getIntent();
//        Bundle bundle=intent2.getBundleExtra("BUNDLE");
//        affirmations=(ArrayList<Affirmation>) bundle.getSerializable("CARTITEM");
        materialButton=(MaterialButton)findViewById(R.id.submit_power_btn);
        materialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PowerActivity.this,Power.class);
//                Bundle bundle=new Bundle();
//                bundle.putSerializable("CARTITEM",(Serializable)affirmations);
//                intent.putExtra("BUNDLE",bundle);
                startActivity(intent);
            }
        });
        backimg=(ImageView)findViewById(R.id.img_back_cart);
        backimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
//                startActivity(new Intent(PowerActivity.this,cartactivity.class));
            }
        });
    }
}