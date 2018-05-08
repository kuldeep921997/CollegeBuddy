package com.example.dell.collegebuddy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Actual_WebPageForTeachers extends AppCompatActivity {

    private WebView webview;
    private String webURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actual_webpageforteachers);

        webURL="https://www.vit.edu.in/staff-vit/faculty-directory";
        webview =(WebView)findViewById(R.id.webView);

        webview.setWebViewClient(new WebViewClient());
        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings().setDomStorageEnabled(true);
        webview.setOverScrollMode(WebView.OVER_SCROLL_NEVER);
        webview.loadUrl(webURL);

    }

    @Override
   public void onBackPressed(){
        if (!webURL.equals(webview.getUrl()))
            webview.goBack();
        else{
            Intent intent = new Intent(Actual_WebPageForTeachers.this,Main2Activity.class);
            startActivity(intent);
            finish();
        }

    }

}