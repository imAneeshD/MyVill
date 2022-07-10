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
import com.example.myvill.pub.Home;

public class login_admin extends AppCompatActivity {
    EditText username, password;
    Button login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_admin);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);

login.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        String uname=username.getText().toString();
        String pass=password.getText().toString();
        if(uname.equals("deepika")&&pass.equals("password")||uname.equals("aneesh")&&pass.equals("password")){
            Intent intent=new Intent(login_admin.this,add_contacts.class);
            Toast.makeText(login_admin.this, "Logged In", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        }
        else {
            Toast.makeText(login_admin.this, "Login Failed", Toast.LENGTH_SHORT).show();
        }
    }
});
    }

    public void back(View view) {
        Intent intent=new Intent(login_admin.this,Home.class);
        startActivity(intent);


    }

    public void login(View view) {
        Intent intent=new Intent(login_admin.this,Home.class);
        startActivity(intent);


    }
}
