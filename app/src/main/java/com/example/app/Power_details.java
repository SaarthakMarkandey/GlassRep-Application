package com.example.app;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class Power_details extends AppCompatActivity implements Axis_Dialogue.AxisDialogueListener{
    private Button button;
   private TextInputLayout user,num;
    private TextInputEditText username,mobilenumber;
    private TextView sph_right,sph_left,cyl_left,cyl_right,add_right,add_left,axis_left,axis_right,warning;
    private CardView sph_right_card,sph_left_card,cyl_right_card,cyl_left_card,add_right_card,add_left_card,axis_left_card,axis_right_card;
    private ImageView backimg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_power_details);
        sph_right=(TextView)findViewById(R.id.sph_right_text);
        sph_left=(TextView)findViewById(R.id.sph_left_text);
        cyl_left=(TextView)findViewById(R.id.cyl_left_text);
        cyl_right=(TextView)findViewById(R.id.cyl_right_text);
        add_left=(TextView)findViewById(R.id.add_left_text);
        add_right=(TextView)findViewById(R.id.add_right_text);
        axis_left=(TextView)findViewById(R.id.axis_left_text);
        axis_right=(TextView)findViewById(R.id.axis_right_text);
        sph_right_card=(CardView)findViewById(R.id.sph_right);
        sph_left_card=(CardView)findViewById(R.id.sph_left);
        cyl_left_card=(CardView)findViewById(R.id.cyl_left);
        cyl_right_card=(CardView)findViewById(R.id.cyl_right);
        add_right_card=(CardView)findViewById(R.id.additional_right);
        add_left_card=(CardView)findViewById(R.id.additional_left);
        axis_left_card=(CardView)findViewById(R.id.axis_left);
        axis_right_card=(CardView)findViewById(R.id.axis_right);
        username=(TextInputEditText) findViewById(R.id.username);
        mobilenumber=(TextInputEditText) findViewById(R.id.mobilenum);
        user=(TextInputLayout)findViewById(R.id.textField);
        num=(TextInputLayout)findViewById(R.id.textField_phone_number);
        button=(Button)findViewById(R.id.submitbtn);
        warning=(TextView)findViewById(R.id.warning);
        backimg=(ImageView)findViewById(R.id.img_back_cart);
        backimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Power_details.this,ModeOfPowerEntry.class));
            }
        });
        sph_right_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Power_details.this,Spherical_chart.class);
                intent.putExtra("type","sphright");
                startActivityForResult(intent,1);
                overridePendingTransition( R.anim.slide_in_up, R.anim.slide_out_up );
            }
        });
        sph_left_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Power_details.this,Spherical_chart.class);
                intent.putExtra("type","sphleft");
                startActivityForResult(intent,2);
                overridePendingTransition( R.anim.slide_in_up, R.anim.slide_out_up );
            }
        });
        cyl_right_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Power_details.this,Cyl_Chart.class);
                intent.putExtra("type","cylright");
                startActivityForResult(intent,3);
                overridePendingTransition( R.anim.slide_in_up, R.anim.slide_out_up );
            }
        });
        cyl_left_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Power_details.this,Cyl_Chart.class);
                intent.putExtra("type","cylleft");
                startActivityForResult(intent,4);
                overridePendingTransition( R.anim.slide_in_up, R.anim.slide_out_up );
            }
        });
        add_left_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Power_details.this,Add_Acitivity.class);
                intent.putExtra("type","addleft");
                startActivityForResult(intent,8);
                overridePendingTransition( R.anim.slide_in_up, R.anim.slide_out_up );
            }
        });
        add_right_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Power_details.this,Add_Acitivity.class);
                intent.putExtra("type","addright");
                startActivityForResult(intent,7);
                overridePendingTransition( R.anim.slide_in_up, R.anim.slide_out_up );
            }
        });
        axis_right_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openDialog("Right Eye","right");
            }
        });
        axis_left_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openDialog("Left Eye","left");
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(axis_left.getText().toString().equals("Select"))|| !(axis_right.getText().toString().equals("Select"))){
                    warning.setVisibility(View.INVISIBLE);
                    if(!(add_left.getText().toString().equals("Select"))|| !(add_right.getText().toString().equals("Select"))){
                        warning.setVisibility(View.INVISIBLE);
                        if(!username.getText().toString().trim().isEmpty()){

                            if(!mobilenumber.getText().toString().isEmpty()){
                                Intent resultIntent=new Intent();
                                resultIntent.putExtra("sphright",sph_right.getText().toString());
                                resultIntent.putExtra("sphleft",sph_left.getText().toString());
                                resultIntent.putExtra("cylright",cyl_right.getText().toString());
                                resultIntent.putExtra("cylleft",cyl_left.getText().toString());
                                resultIntent.putExtra("axisleft",axis_left.getText().toString());
                                resultIntent.putExtra("axisright",axis_right.getText().toString());
                                resultIntent.putExtra("addright",add_right.getText().toString());
                                resultIntent.putExtra("addleft",add_left.getText().toString());
                                resultIntent.putExtra("username",username.getText().toString());
                                setResult(RESULT_OK,resultIntent);
                                finish();
                            }
                            else{
                                Toast.makeText(Power_details.this,"Write Mobile Number",Toast.LENGTH_LONG).show();
                                num.setErrorEnabled(true);
                                num.setError("*Required");
                                num.setBoxStrokeColor(Color.RED);
                            }
                        }
                        else{
                            Toast.makeText(Power_details.this,"Write Valid Name",Toast.LENGTH_LONG).show();
                            user.setErrorEnabled(true);
                            user.setError("*Required");
                            user.setBoxStrokeColor(Color.RED);
                        }

                    }
                    else{
                        warning.setVisibility(View.VISIBLE);
                        Toast.makeText(Power_details.this,"Additional Power Required",Toast.LENGTH_LONG).show();

                    }

                }
                else{
                    warning.setVisibility(View.VISIBLE);
                    Toast.makeText(Power_details.this,"Axis Power Required",Toast.LENGTH_LONG).show();

                }


            }
        });



    }


    private void openDialog(String eye,String side) {
        Axis_Dialogue axis_dialogue=new Axis_Dialogue(eye,side);
        axis_dialogue.show(getSupportFragmentManager(),"axisdialogue");

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,  Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1){
            if(resultCode==RESULT_OK){
                String result=data.getStringExtra("powerchosen");
                sph_right.setText(result);
            }
        }
        if(requestCode==2){
            if(resultCode==RESULT_OK){
                String result=data.getStringExtra("powerchosen");
                sph_left.setText(result);
            }
        }
        if(requestCode==3){
            if(resultCode==RESULT_OK){
                String result=data.getStringExtra("powerchosen");
                cyl_right.setText(result);
            }
        }
        if(requestCode==4){
            if(resultCode==RESULT_OK){
                String result=data.getStringExtra("powerchosen");
                cyl_left.setText(result);
            }
        }
        if(requestCode==7){
            if(resultCode==RESULT_OK){
                String result=data.getStringExtra("powerchosen");
                add_right.setText(result);
            }
        }
        if(requestCode==8){
            if(resultCode==RESULT_OK){
                String result=data.getStringExtra("powerchosen");
                add_left.setText(result);
            }
        }
    }

    @Override
    public void applyAxis(String axis,String side) {
        if(!axis.equals("")){
            if(Integer.parseInt(axis)<=180 && Integer.parseInt(axis)>=0)
                if(side.equals("right"))
                    axis_right.setText(axis);
                else
                    axis_left.setText(axis);
            else{
                Toast toast= Toast.makeText(Power_details.this,"Axis Power Must be between 0 to 180",Toast.LENGTH_LONG);

                toast.show();
            }

        }

    }
}