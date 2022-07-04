package com.example.myvill.pub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.example.myvill.R;

public class contacts extends AppCompatActivity {
    DatabaseAdapter databaseAdapter;
    EditText name, address, nameInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        databaseAdapter = new DatabaseAdapter(this);
        ListView list = findViewById(R.id.contact_list);
        SimpleCursorAdapter simpleCursorAdapter = databaseAdapter.populateListViewFromDB();
        list.setAdapter(simpleCursorAdapter);

    }

    public void back(View view) {
        contacts.super.onBackPressed();
    }
}