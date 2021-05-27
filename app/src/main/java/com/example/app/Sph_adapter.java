package com.example.app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Sph_adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<negativemodel>negativemodels;
    private ArrayList<positivemodel>positivemodels;
    private OnItemClickListener3 mListener;
    private final int TOP=1;
    private final int DOUBLE=2;
    private final int HALF=3;

    public interface OnItemClickListener3{
        void zeroClick(int position);
        void negativeClick(int position);
        void positiveClick(int position);

    }
    public Sph_adapter(ArrayList<positivemodel>positiveModels1, ArrayList<negativemodel>negativeModels1){
        positivemodels=positiveModels1;
        negativemodels=negativeModels1;
    }

    public  void setOnItemClickListener(OnItemClickListener3 listener){
        mListener=listener;
    }

    public static class TopViewHolder extends RecyclerView.ViewHolder{
        public TextView textView;
        public TopViewHolder(@NonNull  View itemView,OnItemClickListener3 listener3) {
            super(itemView);
            textView=itemView.findViewById(R.id.text);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener3!=null){
                        int position=getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION){
                            listener3.zeroClick(position);
                        }
                    }
                }
            });
        }
    }
    public static class DoubleViewHolder extends RecyclerView.ViewHolder{
        public  TextView negtive,positive;

        public DoubleViewHolder(@NonNull  View itemView,OnItemClickListener3 listener3) {
            super(itemView);
            negtive=itemView.findViewById(R.id.negative_power);
            positive=itemView.findViewById(R.id.positive_power);

            negtive.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener3!=null){
                        int position=getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION){
                            listener3.negativeClick(position-1);
                        }
                    }
                }
            });

            positive.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener3!=null){
                        int position=getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION){
                            listener3.positiveClick(position-1);
                        }
                    }
                }
            });
        }
    }
    public static class HalfViewHolder extends RecyclerView.ViewHolder{
        public TextView negative;
        public HalfViewHolder(@NonNull  View itemView,OnItemClickListener3 listener3) {
            super(itemView);
            negative=itemView.findViewById(R.id.negative);
            negative.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener3!=null){
                        int position=getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION){
                            listener3.negativeClick(position-1);
                        }
                    }
                }
            });
        }
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        if(viewType==TOP){
            View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.fullviewpower,parent,false);
            TopViewHolder tvh=new TopViewHolder(view,mListener);
            return tvh;
        }
        else if(viewType==DOUBLE){
            View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.doubleviewpower,parent,false);
            DoubleViewHolder dvh=new DoubleViewHolder(view,mListener);
            return dvh;
        }
        else {
            View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.halfviewpower,parent,false);
            HalfViewHolder hvh=new HalfViewHolder(view,mListener);
            return hvh;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof TopViewHolder){
            TopViewHolder topViewHolder=(TopViewHolder)holder;
            topViewHolder.textView.setText("0.00");
        }
        else if(holder instanceof DoubleViewHolder){
            DoubleViewHolder doubleViewHolder=(DoubleViewHolder)holder;
            negativemodel curritem=negativemodels.get(position-1);

            positivemodel curritem2=positivemodels.get(position-1);
            doubleViewHolder.negtive.setText(curritem.getNegpower());
            doubleViewHolder.positive.setText(curritem2.getPospower());
        }
        else{
            HalfViewHolder halfViewHolder=(HalfViewHolder)holder;
            negativemodel curritem=negativemodels.get(position-1);
            halfViewHolder.negative.setText(curritem.getNegpower());
        }
    }



    @Override
    public int getItemViewType(int position) {
        if(position==0)
            return TOP;
        else if(position>=1 && position<=32)
            return DOUBLE;
        else
            return HALF;
    }

    @Override
    public int getItemCount() {
        return negativemodels.size()+1;
    }
}
