package com.example.app.onBoarding;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.example.app.R;

public class SliderAdapter extends PagerAdapter {

    LayoutInflater layoutInflater;
    Context context;

    public SliderAdapter(Context context) {
        this.context = context;
    }

    int images[]={
            R.drawable.slider1,
            R.drawable.slider2,
            R.drawable.slider3
    };

    int headings[]=
            {
                R.string.sliderHead1,
                R.string.sliderHead2,
                R.string.sliderHead3
            };



    int descriptions[]=
            {
                    R.string.sliderDes1,
                    R.string.sliderDes2,
                    R.string.sliderDes3
            };


    @Override
    public int getCount() {
        return headings.length;
    }


    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.slides_layout,container,false);

        ImageView imageView=view.findViewById(R.id.imageView);
        TextView heading=view.findViewById(R.id.heading);
        TextView desc=view.findViewById(R.id.description);

        Glide.with(view).load(images[position]).into(imageView);
        heading.setText(headings[position]);
        desc.setText(descriptions[position]);

        container.addView(view);

        return view;
    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout) object);
    }
}
