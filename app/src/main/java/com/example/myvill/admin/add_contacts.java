package com.example.myvill.admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ComponentActivity;

import com.example.myvill.R;
import com.example.myvill.db.DBHelper;
import com.example.myvill.pub.view_contacts;

public class add_contacts extends AppCompatActivity {
    EditText name, email, age;
    Button insert, view, delete;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contacts);

        name = findViewById(R.id.name);
        email = findViewById(R.id.address);
        age = findViewById(R.id.phone);
        insert = findViewById(R.id.btnInsert);
        view = findViewById(R.id.btnView);
        delete = findViewById(R.id.btnDelete);

        DB = new DBHelper(this);



        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameTXT = name.getText().toString();
                String emailTXT = email.getText().toString();
                String ageTXT = age.getText().toString();

                Boolean checkinsertdata  = DB.insertuserdata(nameTXT, emailTXT, ageTXT);
                if(checkinsertdata==true)
                {
                    Toast.makeText(add_contacts.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(add_contacts.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();
                }

            }
        });


        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameTXT = name.getText().toString();

                Boolean checkdeletedata  = DB.deleteuserdata(nameTXT);
                if(checkdeletedata==true)
                {
                    Toast.makeText(add_contacts.this, "Entry Deleted", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(add_contacts.this, "Entry Not Deleted", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}