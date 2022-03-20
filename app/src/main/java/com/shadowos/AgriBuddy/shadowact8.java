package com.shadowos.AgriBuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.shadowos.agrifarm.R;

public class shadowact8 extends AppCompatActivity {
    private ImageView ViewClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shadowact8);
        WebView myWebView = (WebView) findViewById(R.id.sourceweb);
        myWebView.loadUrl("https://github.com/gtiwari912");

        ImageView ViewClass = (ImageView) findViewById(R.id.imageView7);
        Glide.with(this).asGif().load(R.drawable.thankyou).into(ViewClass);

    }
    public void BackToMenu(View view) {
        Intent intent = new Intent(this, shadowact2.class);
        startActivity(intent);
}
}
