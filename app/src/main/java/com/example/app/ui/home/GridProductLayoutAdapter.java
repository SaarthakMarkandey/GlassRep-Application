package com.example.app.ui.home;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.app.R;

import java.util.List;

public class GridProductLayoutAdapter extends BaseAdapter {

    List<HorizontalScrollModel> horizontalScrollModelList;

    public GridProductLayoutAdapter(List<HorizontalScrollModel> horizontalScrollModelList) {
        this.horizontalScrollModelList = horizontalScrollModelList;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if(convertView==null){
          view = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_scroll_item,null);
          view.setElevation(0);
          view.setBackgroundColor(Color.parseColor("#f9f3f3"));
          ImageView productImage = view.findViewById(R.id.h_s_product_image);
          TextView productTitle = view.findViewById(R.id.h_s_product_title);
          TextView productPrice = view.findViewById(R.id.h_s_product_price);

          productImage.setImageResource(horizontalScrollModelList.get(position).getProductImage());
          productTitle.setText(horizontalScrollModelList.get(position).getProductTitle());
          productPrice.setText(horizontalScrollModelList.get(position).getProductPrice());
        }
        else{
            view = convertView;
        }
        return view;
    }
}
