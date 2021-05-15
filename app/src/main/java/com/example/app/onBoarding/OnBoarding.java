package com.example.app.onBoarding;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.app.Login;
import com.example.app.R;

public class OnBoarding extends AppCompatActivity {

    ViewPager viewPager;
    LinearLayout dotsLayout;

    SliderAdapter sliderAdapter;
    Button letsGetStarted;
    Animation animation;
    int current;
    TextView dots[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);


        viewPager=findViewById(R.id.slider);
        dotsLayout=findViewById(R.id.dots);
        letsGetStarted=findViewById(R.id.getStarted);



        sliderAdapter=new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);

        addDotes(0);
        viewPager.addOnPageChangeListener(changeListener);
    }

    private void addDotes(int pos)
    {
        dots=new TextView[3];
        dotsLayout.removeAllViews();
        for(int i=0;i<dots.length;i++)
        {
            dots[i]=new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(Color.parseColor("#757575"));
            dotsLayout.addView(dots[i]);

        }

        if(dots.length>0)
        {
            dots[pos].setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        }
    }

    ViewPager.OnPageChangeListener changeListener=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDotes(position);

            current=position;
            if(position==0 || position==1)
            {
                letsGetStarted.setVisibility(View.INVISIBLE);
            }
            else
            {
                animation= AnimationUtils.loadAnimation(OnBoarding.this,R.anim.bottom_anim);
                letsGetStarted.setAnimation(animation);
                letsGetStarted.setVisibility(View.VISIBLE);
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    public void skip(View view)
    {
        startActivity(new Intent(getApplicationContext(), Login.class));
        finish();
    }

    public void getStarted(View view)
    {
        startActivity(new Intent(getApplicationContext(), Login.class));
        finish();
    }

    public void next(View view)
    {
        viewPager.setCurrentItem(current+1);
    }

}