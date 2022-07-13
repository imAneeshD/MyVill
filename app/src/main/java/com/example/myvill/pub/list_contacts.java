package com.example.myvill.pub;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myvill.R;
import com.example.myvill.admin.login_admin;
import com.example.myvill.db.DBHelper;
import com.example.myvill.db.MyAdapter;
import com.google.android.material.navigation.NavigationView;
import java.util.ArrayList;

public class list_contacts extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    RecyclerView recyclerView;
    ArrayList<String> name;
    ArrayList<String> address;
    ArrayList<String> phone;
    DBHelper DB;
    MyAdapter adapter;
    ImageView menu, add, call;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    LinearLayout contentView;

    static final float END_SCALE = 0.7f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_contacts);
        recyclerView = findViewById(R.id.recyclerview);
        DB = new DBHelper(this);
        name = new ArrayList<>();
        address = new ArrayList<>();
        phone = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerview);
        contentView = findViewById(R.id.content);
        add = findViewById(R.id.add);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        menu = findViewById(R.id.menu_icon);
        adapter = new MyAdapter(this, name, address, phone);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        call = findViewById(R.id.call);
        displaydata();
        navigationDrawer();     //Navigation Drawer

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(list_contacts.this, login_admin.class);
                startActivity(intent);
            }
        });
    }

    private void navigationDrawer() {
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);

        menu.setOnClickListener(new View.OnClickListener() {
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


    public void displaydata() {
        Cursor cursor = DB.getdata();
        if (cursor.getCount() == 0) {
            Toast.makeText(list_contacts.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
            return;
        } else {
            while (cursor.moveToNext()) {
                name.add(cursor.getString(0));
                address.add(cursor.getString(1));
                phone.add(cursor.getString(2));

            }

        }

    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:
                Intent intent1 = new Intent(getApplicationContext(), list_contacts.class);
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
        }
        return true;
    }

//    public void add(String view) {
//        Intent intent = new Intent(list_contacts.this, login_admin.class);
//        startActivity(intent);
//    }
}