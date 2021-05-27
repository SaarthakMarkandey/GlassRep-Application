package com.example.app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AddAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {



    private ArrayList<positivemodel> positivemodels;
    private OnItemClickListener4 mListener;

    public interface OnItemClickListener4{

        void positiveClick(int position);

    }
    public AddAdapter(ArrayList<positivemodel>positiveModels1){
        positivemodels=positiveModels1;

    }
    public  void setOnItemClickListener(OnItemClickListener4 listener){
        mListener=listener;
    }

    public static class HalfViewHolder extends RecyclerView.ViewHolder{
        public TextView positive;
        public HalfViewHolder(@NonNull View itemView, OnItemClickListener4 listener3) {
            super(itemView);
            positive=itemView.findViewById(R.id.positive_power);
            positive.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener3!=null){
                        int position=getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION){
                            listener3.positiveClick(position);
                        }
                    }
                }
            });
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.halfviewpower2,parent,false);
        HalfViewHolder hvh=new HalfViewHolder(view,mListener);
        return hvh;
    }

    @Override
    public void onBindViewHolder(@NonNull  RecyclerView.ViewHolder holder, int position) {
        HalfViewHolder halfViewHolder=(HalfViewHolder)holder;
        positivemodel curritem=positivemodels.get(position);
        halfViewHolder.positive.setText(curritem.getPospower());
    }

    @Override
    public int getItemCount() {
        return positivemodels.size();
    }
}
