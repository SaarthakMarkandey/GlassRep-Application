package com.example.app;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ModeOfPowerEntry extends AppCompatActivity {
    private CardView manual_mode,saved_mode,camera_mode,call_mode;
    private String sph_right,sph_left,cyl_left,cyl_right,add_right,add_left,axis_left,axis_right,user,num;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode_of_power_entry);

        manual_mode=(CardView)findViewById(R.id.manual_power);
        saved_mode=(CardView)findViewById(R.id.use_saved_power);
        camera_mode=(CardView)findViewById(R.id.upload_power);
        call_mode=(CardView)findViewById(R.id.power_dont_know);
        manual_mode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ModeOfPowerEntry.this,Power_details.class);
                startActivityForResult(intent,1);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable  Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==1){
            if(resultCode==RESULT_OK){
                sph_right=data.getStringExtra("sphright");
                sph_left=data.getStringExtra("sphleft");
                cyl_left=data.getStringExtra("cylleft");
                cyl_right=data.getStringExtra("cylright");
                axis_left=data.getStringExtra("axisleft");
                axis_right=data.getStringExtra("axisright");
                add_left=data.getStringExtra("addleft");
                add_right=data.getStringExtra("addright");
                user=data.getStringExtra("username");
                Intent resultIntent=new Intent();
                resultIntent.putExtra("sphright",sph_right.toString());
                resultIntent.putExtra("sphleft",sph_left.toString());
                resultIntent.putExtra("cylright",cyl_right.toString());
                resultIntent.putExtra("cylleft",cyl_left.toString());
                resultIntent.putExtra("axisleft",axis_left.toString());
                resultIntent.putExtra("axisright",axis_right.toString());
                resultIntent.putExtra("addright",add_right.toString());
                resultIntent.putExtra("addleft",add_left.toString());
                resultIntent.putExtra("username",user.toString());
                setResult(2,resultIntent);
                finish();
            }
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent resultIntent=new Intent();
        resultIntent.putExtra("backbtnpressed",true);
        setResult(0,resultIntent);
    }
}