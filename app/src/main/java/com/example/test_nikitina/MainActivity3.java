package com.example.test_nikitina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        WebView webView = findViewById(R.id.webView);
        webView.loadUrl("https://developer.android.com/reference/android/arch/persistence/room/package-summary");

    }
}