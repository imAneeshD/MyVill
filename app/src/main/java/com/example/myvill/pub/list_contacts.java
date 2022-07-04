package com.example.myvill.pub;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myvill.R;

public class list_contacts extends AppCompatActivity {

    DatabaseAdapter databaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_contacts);
        PreCreateDB.copyDB(this);
        databaseAdapter = new DatabaseAdapter(this);
        ListView lvContact = findViewById(R.id.lvContact);
        final SimpleCursorAdapter simpleCursorAdapter = databaseAdapter.populateListViewFromDB();
        lvContact.setAdapter(simpleCursorAdapter);
        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Cursor cursor = (Cursor) simpleCursorAdapter.getItem(position);
                String name = cursor.getString(1);
                Toast.makeText(list_contacts.this, name, Toast.LENGTH_LONG).show();
            }
        });
    }
}