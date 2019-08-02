package com.example.viewgroups.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.example.viewgroups.R;

public class WebViewActivity extends AppCompatActivity {

    private Button loadURL;
    private Button loadPage;
    private WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        loadURL = (Button) findViewById(R.id.loadURL);
        loadPage = (Button) findViewById(R.id.loadPage);
        webView = (WebView) findViewById(R.id.webView);


        loadURL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webView.setWebViewClient(new MyWebViewClient());
                webView.getSettings().setJavaScriptEnabled(true);
                webView.loadUrl("https://www.tutorialspoint.com/spring_boot/spring_boot_introduction.htm");
            }
        });


        loadPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //String s = "<html><body><marquee>Hello World !!</marquee></body></html>";
                //webView.loadData(s, "text/html", "UTF-8");
                webView.loadUrl("file:///android_asset/test.html");
            }
        });
    }

    public void gotoGridView(View view) {
        Intent i = new Intent(this, GridViewActivity.class);
        startActivity(i);
    }

    //Creating a custom WebViewClient so that urls within the page should get opened in the same activity
    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            findViewById(R.id.progress1).setVisibility(View.VISIBLE);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            findViewById(R.id.progress1).setVisibility(View.GONE);
        }
    }


   @Override
    public void onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack();
        }
        else {
            super.onBackPressed();
        }
    }
}
