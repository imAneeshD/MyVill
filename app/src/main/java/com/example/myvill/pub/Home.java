package com.example.myvill.pub;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.myvill.R;
import com.example.myvill.profile.profile;
import com.example.myvill.pub.contacts.education;
import com.example.myvill.pub.contacts.generalshops;
import com.example.myvill.pub.contacts.government;
import com.example.myvill.pub.contacts.healthcare;
import com.example.myvill.pub.contacts.temples;
import com.example.myvill.pub.property.land;
import com.example.myvill.pub.property.mojini;
import com.google.android.material.navigation.NavigationView;

public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView menu_icon;
    LinearLayout contentView;

    static final float END_SCALE = 0.7f;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home);

        //Menu hooks
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        menu_icon = findViewById(R.id.menu_icon);
        contentView = findViewById(R.id.content);
        navigationDrawer();     //Navigation Drawer
    }


    private void navigationDrawer() {
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);

        menu_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (drawerLayout.isDrawerVisible(GravityCompat.START))
                    drawerLayout.closeDrawer(GravityCompat.START);
                else
                    drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        animateNavigationDrawer();
    }

    private void animateNavigationDrawer() {

        //Add any color or remove it to use the default one!
        //To make it transparent use Color.Transparent in side setScrimColor();
        //drawerLayout.setScrimColor(Color.TRANSPARENT);

        drawerLayout.setScrimColor(getResources().getColor(R.color.colorAccent));
        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

                // Scale the View based on current slide offset
                final float diffScaledOffset = slideOffset * (1 - END_SCALE);
                final float offsetScale = 1 - diffScaledOffset;
                contentView.setScaleX(offsetScale);
                contentView.setScaleY(offsetScale);

                // Translate the View, accounting for the scaled width
                final float xOffset = drawerView.getWidth() * slideOffset;
                final float xOffsetDiff = contentView.getWidth() * diffScaledOffset / 2;
                final float xTranslation = xOffset - xOffsetDiff;
                contentView.setTranslationX(xTranslation);
            }
        });

    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerVisible(GravityCompat.START))
            drawerLayout.closeDrawer(GravityCompat.START);
        else
            super.onBackPressed();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:
                Intent intent1 = new Intent(getApplicationContext(), Home.class);
                startActivity(intent1);
                break;
            case R.id.nav_services:
                Intent intent2 = new Intent(getApplicationContext(), mojini.class);
                startActivity(intent2);
                break;
            case R.id.nav_news:
                Intent intent3 = new Intent(getApplicationContext(), news.class);
                startActivity(intent3);
                break;
            case R.id.nav_land:
                Intent intent4 = new Intent(getApplicationContext(), land.class);
                startActivity(intent4);
                break;
            case R.id.profile:
                Intent intent5 = new Intent(getApplicationContext(), profile.class);
                startActivity(intent5);
                break;
            case R.id.aboutus:
                Intent intent6 = new Intent(getApplicationContext(), profile.class);
                startActivity(intent6);
                break;
        }
        return true;

    }


    public void education(View view) {
        Intent intent = new Intent(Home.this, education.class);
        startActivity(intent);
    }

    public void healthcare(View view) {
        Intent intent = new Intent(Home.this, healthcare.class);
        startActivity(intent);
    }

    public void generalshops(View view) {
        Intent intent = new Intent(Home.this, generalshops.class);
        startActivity(intent);
    }

    public void government(View view) {
        Intent intent = new Intent(Home.this, government.class);
        startActivity(intent);
    }


    public void temple(View view) {
        Intent intent = new Intent(Home.this, temples.class);
        startActivity(intent);
    }




//    public void trade(View view) {
//        Intent intent=new Intent(land.this, trade.class);
//        startActivity(intent);
//    }
}