package com.example.app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {

    ImageView backgroundImage;

    private static int SPLASH_TIMER=1500;

    Animation sideAnim;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        backgroundImage=findViewById(R.id.appIcon);

        sideAnim= AnimationUtils.loadAnimation(this,R.anim.side_anim);

        backgroundImage.setAnimation(sideAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                sharedPreferences=getSharedPreferences("onBoardingScreen",MODE_PRIVATE);

                boolean isFirstTime=sharedPreferences.getBoolean("firstTime",true);

                if(isFirstTime)
                {
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putBoolean("firstTime",false);
                    editor.commit();
                    startActivity(new Intent(getApplicationContext(), com.example.app.onBoarding.OnBoarding.class));
                    finish();
                }
                else
                {
                    startActivity(new Intent(getApplicationContext(), Login.class));
                    finish();
                }
            }
        },SPLASH_TIMER);
    }
}