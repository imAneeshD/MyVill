package com.example.myvill.common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myvill.R;
import com.example.myvill.pub.Home;
import com.example.myvill.pub.list_contacts;

public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_TIMER=2000;

    ImageView backImg;
    TextView pow;

    //Animation
    Animation sideAnim,bottomAnim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.spalsh_screen);

        backImg=findViewById(R.id.background_image);
        pow=findViewById(R.id.powered_by);


        sideAnim= AnimationUtils.loadAnimation(this, R.anim.side_anim);
        bottomAnim=AnimationUtils.loadAnimation(this,R.anim.bottom_anim);

        backImg.setAnimation(sideAnim);
        pow.setAnimation(bottomAnim);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(SplashScreen.this, list_contacts.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_TIMER);
    }
}