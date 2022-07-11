package com.example.myvill.pub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.myvill.R;

public class revenue extends AppCompatActivity {
WebView web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        web=findViewById(R.id.web);
        WebSettings webSettings=web.getSettings();
        webSettings.setJavaScriptEnabled(true);
        web.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        web.setWebViewClient(new Callback());
        web.loadUrl("https://www.landrecords.karnataka.gov.in/service3/");
    }

    public void back(View view) {
<<<<<<<< HEAD:app/src/main/java/com/example/myvill/pub/revenue.java
        Intent intent=new Intent(revenue.this, land.class);
========
        Intent intent=new Intent(services.this, land.class);
>>>>>>>> 2c3872c (Commiting the Project):app/src/main/java/com/example/myvill/pub/services.java
        startActivity(intent);
    }

    private class Callback extends WebViewClient {
        @Override
        public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
            return false;
        }
    }
}