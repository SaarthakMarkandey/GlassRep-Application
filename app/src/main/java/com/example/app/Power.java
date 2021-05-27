package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Power extends AppCompatActivity {
    private ArrayList<Affirmation>affirmations;
    private RecyclerView mrecylerview;
    private PowerAdapter mAdapter;
    private RecyclerView.LayoutManager mlayoutManager;
    private int curritem;
    private Button submit_all_power;
    private ImageView backimg;

    static ArrayList<PowerModel>powerModels;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_power2);
//        Intent intent2=getIntent();
//        Bundle bundle=intent2.getBundleExtra("BUNDLE");
//        affirmations=(ArrayList<Affirmation>) bundle.getSerializable("CARTITEM");
        submit_all_power=(Button)findViewById(R.id.submit_all_powers);
        backimg=(ImageView)findViewById(R.id.img_back_cart);
        backimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        createPowerList();
        setPowerAdapter();

    }

    private void setPowerAdapter() {
        mrecylerview=(RecyclerView)findViewById(R.id.power_recycler_view);
        mrecylerview.setHasFixedSize(true);
        mlayoutManager=new LinearLayoutManager(this);
        mAdapter=new PowerAdapter(powerModels);
        mrecylerview.setLayoutManager(mlayoutManager);
        mrecylerview.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener2(this,new PowerAdapter.OnItemClickListener2() {
            @Override
            public void allPowersGiven(int check) {
                enableButton(check);
            }

            @Override
            public void onButtonClick(int position) {

                setPowers(position);
            }

            @Override
            public void onShowPower(int position) {

            }

            @Override
            public void onHidePower(int position) {

            }
        });

    }

    private void enableButton(int checked) {
        if(checked<powerModels.size())
            submit_all_power.setAlpha(0.5f);
        else
            submit_all_power.setAlpha(1.0f);
        submit_all_power.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checked<powerModels.size()){
                    Toast.makeText(Power.this,"Please fill powers for all Spectacles",Toast.LENGTH_LONG).show();

                }
                else{
                    Intent intent=new Intent(getApplicationContext(), PaymentDetails.class);
                    startActivity(intent);
                    finish();
                }

            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable  Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1){
            if(resultCode==2){

                powerModels.get(curritem).change_sph_right(data.getStringExtra("sphright").toString().equals("Select")?"":data.getStringExtra("sphright").toString());
                powerModels.get(curritem).change_sph_left(data.getStringExtra("sphleft").toString().equals("Select")?"":data.getStringExtra("sphleft").toString());
                powerModels.get(curritem).change_cyl_left(data.getStringExtra("cylleft").toString().equals("Select")?"":data.getStringExtra("cylleft").toString());
                powerModels.get(curritem).change_cyl_right(data.getStringExtra("cylright").toString().equals("Select")?"":data.getStringExtra("cylright").toString());
                powerModels.get(curritem).change_axis_left(data.getStringExtra("axisleft").toString().equals("Select")?"":data.getStringExtra("axisleft").toString());
                powerModels.get(curritem).change_axis_right(data.getStringExtra("axisright").toString().equals("Select")?"":data.getStringExtra("axisright").toString());
                powerModels.get(curritem).change_add_left(data.getStringExtra("addleft").toString().equals("Select")?"":data.getStringExtra("addleft").toString());
                powerModels.get(curritem).change_add_right(data.getStringExtra("addright").toString().equals("Select")?"":data.getStringExtra("addright").toString());
                powerModels.get(curritem).change_username(data.getStringExtra("username").toString().equals("Select")?"":data.getStringExtra("username").toString());
                mAdapter.notifyDataSetChanged();


            }

        }
    }

    private void setPowers(int position) {
        curritem=position;
        Intent intent=new Intent(Power.this,ModeOfPowerEntry.class);
        startActivityForResult(intent,1);





    }

    private void createPowerList() {
        powerModels=new ArrayList<>();
        powerModels.add(new PowerModel(R.drawable.glass,"Sunglasses","#656545","blue frame elegant body","","","","","","","","",""));
        powerModels.add(new PowerModel(R.drawable.glass,"Sunglasses","#656545","blue frame elegant body","","","","","","","","",""));
//        powerModels.add(new PowerModel(R.drawable.glass,"Sunglasses","#656545","blue frame elegant body","","","","","","","","",""));
//        powerModels.add(new PowerModel(R.drawable.glass,"Sunglasses","#656545","blue frame elegant body","","","","","","","","",""));
//        powerModels.add(new PowerModel(R.drawable.glass,"Sunglasses","#656545","blue frame elegant body","","","","","","","","",""));
//
//        powerModels.add(new PowerModel(R.drawable.glass,"Sunglasses","#656545","blue frame elegant body","","","","","","","","",""));
//        powerModels.add(new PowerModel(R.drawable.glass,"Sunglasses","#656545","blue frame elegant body","","","","","","","","",""));
    }
}