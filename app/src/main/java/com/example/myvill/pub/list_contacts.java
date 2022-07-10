package com.example.myvill.pub;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.RenderNode;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

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

public class list_contacts extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> name, address, phone;
    DBHelper DB;
    MyAdapter adapter;
    ImageView back,add,call;

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
        contentView=findViewById(R.id.content);
        add=findViewById(R.id.add);
        call=findViewById(R.id.call);

back=findViewById(R.id.back);
        adapter = new MyAdapter(this, name, address, phone);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        displaydata();

add.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent=new Intent(list_contacts.this, login_admin.class);
        startActivity(intent);
    }
});

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(list_contacts.this,Home.class);
                startActivity(intent);
            }
        });





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
                call.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                       String number=phone.toString();
                                Intent intent=new Intent(Intent.ACTION_DIAL);
                                intent.setData(Uri.parse("tel:"+number));
                                startActivity(intent);

                    }
                });
            }
        }

    }

    public void call(View view) {

    }


}