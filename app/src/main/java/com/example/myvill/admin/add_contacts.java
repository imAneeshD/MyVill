package com.example.myvill.admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myvill.R;
import com.example.myvill.db.DBHelper;

public class add_contacts extends AppCompatActivity {
    EditText name, email, age;
    Button insert, view, delete;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contacts);

        name = findViewById(R.id.name);
        email= findViewById(R.id.address);
        age = findViewById(R.id.phone);
        insert = findViewById(R.id.btnInsert);
        view = findViewById(R.id.btnView);
        delete = findViewById(R.id.btnDelete);

    }
}