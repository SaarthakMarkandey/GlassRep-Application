package com.example.app;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private  ArrayList<Affirmation> affirmation;
    private OnItemClickListener mListener;

    //    public static final int HEADER=1;
    public static final int NORMAL=2;
    public static final int FOOTER=3;

    public interface OnItemClickListener{
        void OnItemClick(int position);
        void OnDeleteClick(int position);
        void OnIncreaseClick(int position);
        void OnDecreaseClick(int position);
        void OnWishClick(int position);
    }
    public  void setOnItemClickListener(OnItemClickListener listener){
        mListener=listener;
    }


    public static class FooterViewHolder extends RecyclerView.ViewHolder{
        public TextView mourprice;
        public FooterViewHolder(@NonNull View itemView,OnItemClickListener listener) {
            super(itemView);
            mourprice=itemView.findViewById(R.id.our_price);
        }
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder{

        public ImageView mImageView;
        public TextView mprod_name;
        public TextView mprod_code;
        public TextView mprod_size;
        public TextView mprod_price;
        public TextView mprod_availibilty;
        public  TextView mprod_quantity;
        public Button removebtn;
        public ImageView increasequantimg;
        public ImageView decreasequantimg;
        public  ImageView mheart;
        public ItemViewHolder(@NonNull View itemView,OnItemClickListener listener) {
            super(itemView);
            mImageView=itemView.findViewById(R.id.img_product);
            mprod_name=itemView.findViewById(R.id.prod_name);
            mprod_code=itemView.findViewById(R.id.prod_code);
            mprod_size=itemView.findViewById(R.id.prod_size);
            mprod_price=itemView.findViewById(R.id.prod_price);
            mprod_availibilty=itemView.findViewById(R.id.prod_availability);
            removebtn=itemView.findViewById(R.id.remove_item);
            mprod_quantity=itemView.findViewById(R.id.prod_quantity);
            increasequantimg=itemView.findViewById(R.id.increase_quantity);
            decreasequantimg=itemView.findViewById(R.id.reduce_quantity);
            mheart=itemView.findViewById(R.id.heart);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener!=null){
                        int position=getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION){
                            listener.OnItemClick(position);
                        }
                    }
                }
            });
            removebtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener!=null){
                        int position=getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION){
                            listener.OnDeleteClick(position);
                        }
                    }
                }
            });

            increasequantimg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener!=null){
                        int position=getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION){
                            listener.OnIncreaseClick(position);
                        }
                    }
                }
            });
            decreasequantimg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener!=null){
                        int position=getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION){
                            listener.OnDecreaseClick(position);
                        }
                    }
                }
            });
            mheart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener!=null){
                        int position=getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION){
                            listener.OnWishClick(position);
                        }
                    }
                }
            });

        }
    }
    public RecyclerViewAdapter(ArrayList<Affirmation> affirmationArrayList){
        affirmation=affirmationArrayList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType==NORMAL){
            View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item_layout,parent,false);
            ItemViewHolder ivh=new ItemViewHolder(view,mListener);
            return ivh;
        }
        else {
            View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.price_detail,parent,false);
            FooterViewHolder ivh=new FooterViewHolder(view,mListener);
            return ivh;
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof FooterViewHolder){
            FooterViewHolder footerViewHolder=(FooterViewHolder)holder;
            footerViewHolder.mourprice.setText("₹4000/-");
        }
        else{
            ItemViewHolder itemViewHolder=(ItemViewHolder)holder;
            Affirmation currItem=affirmation.get(position);
            itemViewHolder.mImageView.setImageResource(currItem.getImageView());
            itemViewHolder.mprod_name.setText(currItem.getprod_name());
            itemViewHolder.mprod_code.setText(currItem.getprod_code());
            itemViewHolder.mprod_size.setText(currItem.getprod_size());
            itemViewHolder.mprod_price.setText(currItem.getprod_price());
            itemViewHolder.mprod_availibilty.setText(currItem.getprod_availbilty());
            itemViewHolder.mprod_quantity.setText(currItem.getprod_quantity());
            itemViewHolder.mheart.setImageResource(currItem.getmWishimg());
        }
    }




    @Override
    public int getItemCount() {
        return affirmation.size()+1;
    }

    @Override
    public int getItemViewType(int position) {

        if(position==affirmation.size()){
            return FOOTER;
        }
        else {
            return NORMAL;
        }

    }



}
