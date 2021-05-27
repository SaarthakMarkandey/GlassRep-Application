package com.example.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PowerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private  ArrayList<PowerModel> powerModels;
    private Context mcontext;
    private OnItemClickListener2 mListener;
    public static final int NORMAL=1;
    int checked=0;

    public interface OnItemClickListener2{
        void allPowersGiven(int check);
        void onButtonClick(int position);
        void onShowPower(int position);
        void onHidePower(int position);
    }

    public  void setOnItemClickListener2(Context context,OnItemClickListener2 listener){
        mListener=listener;
        mcontext=context;
    }


    public PowerAdapter(ArrayList<PowerModel>powerModelArrayList){
        powerModels=powerModelArrayList;
    }
    public static class NormalViewHolder extends RecyclerView.ViewHolder{
        Button addPower;
        private RelativeLayout nameplate;
        private LinearLayout full_layout,power_info;
        private ImageView p_imageView,updown;
        private TextView p_prod_name,p_prod_code,p_prod_specs,p_sph_right,p_sph_left,p_cyl_right,p_cyl_left,p_axis_right,p_axis_left,p_additional_right,p_additional_left,p_username,p_normalText;
        public NormalViewHolder
                (@NonNull View itemView,OnItemClickListener2 listener2,Context context2) {
            super(itemView);
            addPower=itemView.findViewById(R.id.addpower_item);
            p_imageView=itemView.findViewById(R.id.img_product);
            p_prod_name=itemView.findViewById(R.id.prod_name);
            p_prod_code=itemView.findViewById(R.id.prod_code);
            p_prod_specs=itemView.findViewById(R.id.prod_specs);
            p_sph_right=itemView.findViewById(R.id.right_sph);
            p_sph_left=itemView.findViewById(R.id.left_sph);
            p_cyl_right=itemView.findViewById(R.id.right_cyl);
            p_cyl_left=itemView.findViewById(R.id.left_cyl);
            p_axis_right=itemView.findViewById(R.id.right_axis);
            p_axis_left=itemView.findViewById(R.id.left_axis);
            p_additional_right=itemView.findViewById(R.id.right_additional);
            p_additional_left=itemView.findViewById(R.id.left_additional);
            p_username=itemView.findViewById(R.id.username);
            updown=itemView.findViewById(R.id.arrow_up_down);
            full_layout=itemView.findViewById(R.id.total_power_layout);
            power_info=itemView.findViewById(R.id.power_info);
            p_normalText=itemView.findViewById(R.id.normal_text);
            nameplate=itemView.findViewById(R.id.given_power);

            addPower.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(listener2!=null){
                        int position=getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION) {
                            listener2.onButtonClick(position);




                        }
                    }
                }
            });
            updown.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener2!=null){
                        int position=getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION){
                            if(updown.getDrawable().getConstantState()== context2.getDrawable(R.drawable.ic_baseline_keyboard_arrow_down_24).getConstantState()){
                                power_info.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                                updown.setImageResource(R.drawable.ic_baseline_keyboard_arrow_up_24);
                            }
                            else{
                                power_info.setLayoutParams(new LinearLayout.LayoutParams(0,0));
                                updown.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_24);
                            }
                        }

                    }
                }
            });




        }
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.powercardholderbeforepowerentry,parent,false);
        NormalViewHolder nvh=new NormalViewHolder(view,mListener,mcontext);
        return nvh;
    }

    @Override
    public void onBindViewHolder(@NonNull  RecyclerView.ViewHolder holder, int position) {
        NormalViewHolder normalViewHolder=(NormalViewHolder)holder;
        PowerModel curritem=powerModels.get(position);
        normalViewHolder.p_imageView.setImageResource(curritem.getImage());
        normalViewHolder.p_prod_name.setText(curritem.getprod_name());
        normalViewHolder.p_prod_code.setText(curritem.getprod_code());
        normalViewHolder.p_prod_specs.setText(curritem.getprod_specs());
        normalViewHolder.p_sph_right.setText(curritem.get_sph_right());
        normalViewHolder.p_sph_left.setText(curritem.get_sph_left());
        normalViewHolder.p_cyl_right.setText(curritem.get_cyl_right());
        normalViewHolder.p_cyl_left.setText(curritem.get_cyl_left());
        normalViewHolder.p_additional_right.setText(curritem.get_additional_right());
        normalViewHolder.p_additional_left.setText(curritem.get_additional_left());
        normalViewHolder.p_axis_right.setText(curritem.get_axis_right());
        normalViewHolder.p_axis_left.setText(curritem.get_axis_left());
        normalViewHolder.p_username.setText(curritem.get_username());
        if(normalViewHolder.p_sph_right.getText().toString().equals("")&&normalViewHolder.p_sph_left.getText().toString().equals("") && normalViewHolder.p_cyl_left.getText().toString().equals("")&& normalViewHolder.p_cyl_right.getText().toString().equals("") && normalViewHolder.p_axis_left.getText().toString().equals("")&& normalViewHolder.p_axis_right.getText().toString().equals("")&&normalViewHolder.p_additional_left.getText().toString().equals("")&&normalViewHolder.p_additional_right.getText().toString().equals("")&&normalViewHolder.p_username.getText().toString().equals("")){
            normalViewHolder.full_layout.setLayoutParams(new FrameLayout.LayoutParams(0,0));
        }
        else{
            normalViewHolder.addPower.setVisibility(View.INVISIBLE);
            normalViewHolder.nameplate.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

            normalViewHolder.full_layout.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            normalViewHolder.p_normalText.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));


            normalViewHolder.power_info.setLayoutParams(new LinearLayout.LayoutParams(0, 0));
        }
        if(normalViewHolder.addPower.getVisibility()==View.INVISIBLE){
            checked++;

        }
        System.out.println(checked);
        mListener.allPowersGiven(checked);






    }

    @Override
    public int getItemViewType(int position) {
        return NORMAL;
    }

    @Override
    public int getItemCount() {
        return powerModels.size();
    }

}
