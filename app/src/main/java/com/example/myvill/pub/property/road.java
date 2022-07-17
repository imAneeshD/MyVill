package com.example.myvill.pub.property;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.myvill.R;

public class road extends AppCompatActivity {
    WebView web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        web=findViewById(R.id.web);
        WebSettings webSettings=web.getSettings();
        webSettings.setJavaScriptEnabled(true);
        web.setWebViewClient(new road.Callback());
        web.loadUrl("https://bsk.karnataka.gov.in/BSK/cs/loadOnlineServicesBeforeLogin");
    }
    public void back(View view) {
        Intent intent=new Intent(road.this, land.class);
        startActivity(intent);
    }
    private class Callback extends WebViewClient {
        @Override
        public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
            return false;
        }
    }
}