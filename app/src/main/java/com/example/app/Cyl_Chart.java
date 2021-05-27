package com.example.app;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Cyl_Chart extends AppCompatActivity {
    private ArrayList<positivemodel> positivemodelArrayList;
    private ArrayList<negativemodel>negativemodelArrayList;
    private RecyclerView recyclerView;
    private Sph_adapter sAdapter;
    private RecyclerView.LayoutManager layoutManager;
    TextView eye;
    ImageView cross;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cyl_chart);
        createPositiveList();
        createNegativeList();
        setAdapter();
        Intent intent=getIntent();
        cross=(ImageView)findViewById(R.id.go_back);
        cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        eye=(TextView)findViewById(R.id.eye);
        String type=intent.getStringExtra("type");
        if(type.equals("cylright")){
            eye.setText("Right Eye");
        }
        else
            eye.setText("Left Eye");
    }

    private void setAdapter() {
        recyclerView=(RecyclerView)findViewById(R.id.sph_recycler_view);

        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        sAdapter=new Sph_adapter(positivemodelArrayList,negativemodelArrayList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(sAdapter);
        sAdapter.setOnItemClickListener(new Sph_adapter.OnItemClickListener3() {
            @Override
            public void zeroClick(int position) {
                Intent resultIntent=new Intent();
                resultIntent.putExtra("powerchosen","0.00");
                setResult(RESULT_OK,resultIntent);
                finish();
            }

            @Override
            public void negativeClick(int position) {
                Intent resultIntent=new Intent();
                resultIntent.putExtra("powerchosen",negativemodelArrayList.get(position).getNegpower());
                setResult(RESULT_OK,resultIntent);
                finish();
            }

            @Override
            public void positiveClick(int position) {
                Intent resultIntent=new Intent();
                resultIntent.putExtra("powerchosen",positivemodelArrayList.get(position).getPospower());
                setResult(RESULT_OK,resultIntent);
                finish();
            }
        });
    }

    private void createNegativeList() {
        negativemodelArrayList=new ArrayList<>();

        for(double i=-0.25;i>=-5.00;i-=0.25){
            negativemodelArrayList.add(new negativemodel(String.format("%.2f",i)));
        }
    }

    private void createPositiveList() {
        positivemodelArrayList=new ArrayList<>();

        for(double i=0.25;i<=5.00;i+=0.25){
            positivemodelArrayList.add(new positivemodel("+"+String.format("%.2f",i)));
        }
    }
}