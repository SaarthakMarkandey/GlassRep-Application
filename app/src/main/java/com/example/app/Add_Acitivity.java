package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Add_Acitivity extends AppCompatActivity {
    private ArrayList<positivemodel> positivemodelArrayList;
    TextView eye;
    ImageView cross;
    private RecyclerView recyclerView;
    private AddAdapter sAdapter;
    private RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_acitivity);
        cross=(ImageView)findViewById(R.id.go_back);
        cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        eye=(TextView)findViewById(R.id.eye);
        Intent intent=getIntent();
        String type=intent.getStringExtra("type");
        if(type.equals("sphright"))
            eye.setText("Right Eye");
        else
            eye.setText("Left Eye");
        createpositivelist();
        setAdapter();
    }

    private void setAdapter() {
        recyclerView=(RecyclerView)findViewById(R.id.add_recycler_view);

        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        sAdapter=new AddAdapter(positivemodelArrayList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(sAdapter);
        sAdapter.setOnItemClickListener(new AddAdapter.OnItemClickListener4() {
            @Override
            public void positiveClick(int position) {
                Intent resultIntent=new Intent();
                resultIntent.putExtra("powerchosen",positivemodelArrayList.get(position).getPospower());
                setResult(RESULT_OK,resultIntent);
                finish();
            }
        });

    }


    private void createpositivelist() {
        positivemodelArrayList=new ArrayList<>();

        for(double i=0.75;i<=4.00;i+=0.25){
            positivemodelArrayList.add(new positivemodel("+"+String.format("%.2f",i)));
        }
    }
}