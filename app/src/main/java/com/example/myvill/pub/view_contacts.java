package com.example.myvill.pub;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myvill.R;
import com.example.myvill.db.DBHelper;
import com.example.myvill.db.MyAdapter;

import java.util.ArrayList;

public class view_contacts extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> name, address, phone;
    DBHelper DB;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_contact);
        recyclerView = findViewById(R.id.recycleview);
DB=new DBHelper(this);
        name=new ArrayList<>();
address=new ArrayList<>();
phone=new ArrayList<>();

recyclerView=findViewById(R.id.)

    }
}