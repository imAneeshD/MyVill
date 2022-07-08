package com.example.myvill.admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myvill.R;

public class login_admin extends AppCompatActivity {
    EditText username, password;
    Button login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_admin);

        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        login=findViewById(R.id.login);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname=username.getText().toString();
                String pass=password.getText().toString();


                if(uname.equals("aneesh") && pass.equals("123") || uname.equals("deepika") && pass.equals("deepika"))
                {
                    Intent intent=new Intent(login_admin.this,add_contacts.class);
                    startActivity(intent);
                }
                else {
                    Toast toast=Toast.makeText(getApplicationContext(),"Login Failed",Toast.LENGTH_SHORT);
                    toast.setMargin(50,50);
                    toast.show();                  }
            }
        });
    }

}
