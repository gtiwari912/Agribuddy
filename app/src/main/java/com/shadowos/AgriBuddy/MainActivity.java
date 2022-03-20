package com.shadowos.AgriBuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.shadowos.agrifarm.R;

import static androidx.core.content.ContextCompat.getSystemService;

public class MainActivity extends AppCompatActivity {
ImageView b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        Log.d("tag912", "level1");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Log.d("tag912", "level2");
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        Glide.with(this).asGif().load(R.drawable.giphy22).into(imageView);

//        Log.d("tag912", "level3");
        ImageView imageView4 = (ImageView) findViewById(R.id.imageView4);
        Glide.with(this).asGif().load(R.drawable.taphere).into(imageView4);
    }

    @SuppressLint("ClickableViewAccessibility")
    public void stylelame(View view) {
        Intent intent = new Intent(this, com.shadowos.AgriBuddy.shadowact2.class);
        startActivity(intent);



        ImageView b = (ImageView) findViewById(R.id.imageView4);
        b.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Vibrator vb = (Vibrator)   getSystemService(Context.VIBRATOR_SERVICE);
                assert vb != null;
                vb.vibrate(10);
                return false;
            }
        });

    }

}