package com.example.myvill.pub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.example.myvill.R;

public class listView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_list_view);


    }

    public void services(View view) {
        Intent intent=new Intent(listView.this,services.class);
        startActivity(intent);
    }

    public void news(View view) {
        Intent intent=new Intent(listView.this,news.class);
        startActivity(intent);
    }

    public void status(View view) {
        Intent intent=new Intent(listView.this,status.class);
        startActivity(intent);
    }

    public void general_info(View view) {
        Intent intent=new Intent(listView.this,generalInfo.class);
        startActivity(intent);
    }

    public void community(View view) {
        Intent intent=new Intent(listView.this,community.class);
        startActivity(intent);
    }

    public void propery(View view) {
        Intent intent=new Intent(listView.this,property.class);
        startActivity(intent);
    }


}