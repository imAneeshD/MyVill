package com.example.myvill.pub;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myvill.R;

public class mojini extends AppCompatActivity {


        WebView web;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_webview);
            web=findViewById(R.id.web);
            WebSettings webSettings=web.getSettings();
            webSettings.setJavaScriptEnabled(true);
            web.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
            web.setWebViewClient(new mojini.Callback());
            web.loadUrl("https://bhoomojini.karnataka.gov.in/service27");
        }

        public void back(View view) {
            Intent intent=new Intent(mojini.this, land.class);
            startActivity(intent);
        }

        private class Callback extends WebViewClient {
            @Override
            public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
                return false;
            }
        }
    }

