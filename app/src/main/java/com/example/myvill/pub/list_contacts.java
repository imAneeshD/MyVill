package com.example.myvill.pub;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myvill.R;
import com.example.myvill.db.DBHelper;
import com.example.myvill.db.MyAdapter;

import java.util.ArrayList;

public class list_contacts extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> name, address, phone;
    DBHelper DB;
    MyAdapter adapter;


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

        adapter = new MyAdapter(this, name, address, phone);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        displaydata();

    }

    private void displaydata() {

        Cursor cursor = DB.getdata();
        if(cursor.getCount()==0)
        {
            Toast.makeText(list_contacts.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
            return;
        }
        else
        {
            while(cursor.moveToNext())
            {
                name.add(cursor.getString(0));
                address.add(cursor.getString(1));
                phone.add(cursor.getString(2));
            }
        }

    }

    public void call(View view) {

    }

    public void add(View view) {


    }
}