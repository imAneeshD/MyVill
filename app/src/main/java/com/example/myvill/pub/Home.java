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
import com.example.myvill.admin.login_admin;
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
            case R.id.nav_contacts:
                Intent intent = new Intent(getApplicationContext(), list_contacts.class);
                startActivity(intent);
                break;
            case R.id.nav_news:
                Intent intent2 = new Intent(getApplicationContext(), news.class);
                startActivity(intent2);
                break;
            case R.id.nav_land:
                Intent intent3 = new Intent(getApplicationContext(), property.class);
                startActivity(intent3);
                break;
        }
        return true;

    }


    public void services(View view) {
        Intent intent = new Intent(Home.this, services.class);
        startActivity(intent);
    }

    public void news(View view) {
        Intent intent = new Intent(Home.this, news.class);
        startActivity(intent);
    }

    public void status(View view) {
        Intent intent = new Intent(Home.this, status.class);
        startActivity(intent);
    }

    public void general_info(View view) {
        Intent intent = new Intent(Home.this, generalInfo.class);
        startActivity(intent);
    }

    public void community(View view) {
        Intent intent = new Intent(Home.this, pedencyReport.class);
        startActivity(intent);
    }

    public void property(View view) {
        Intent intent = new Intent(Home.this, property.class);
        startActivity(intent);
    }


    public void road(View view) {
        Intent intent = new Intent(Home.this, road.class);
        startActivity(intent);

    }

    public void add(View view) {
        Intent intent = new Intent(Home.this, login_admin.class);
        startActivity(intent);
    }


//    public void trade(View view) {
//        Intent intent=new Intent(Home.this, trade.class);
//        startActivity(intent);
//    }
}